/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.dto.pagamentoDTO;
import com.example.demo.dto.retornoPagementoDTO;
import com.example.demo.model.Credor;
import com.example.demo.model.Pagamento;
import com.example.demo.repository.CredorRepository;
import com.example.demo.repository.EnteDevedorRepository;
import com.example.demo.repository.PagamentoRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PedroVitorDev
 */

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    
    @Autowired
    private PagamentoRepository pagamanetoRepository;
    
    @Autowired
    private CredorRepository credorRepository;
    
    @Autowired
    private EnteDevedorRepository enteDevedorRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping
    public List<pagamentoDTO> listar() {
        return pagamanetoRepository.findAll()
                .stream()
                .map(this::topagamentoDto)
                .collect(Collectors.toList());
    }
     
    private pagamentoDTO pagamentoDTO(Pagamento pagamento) {
        return modelMapper.map(pagamento, pagamentoDTO.class);
    }
        
    private pagamentoDTO topagamentoDto(Pagamento pagamento ) {
         
        var pagamentoDTO = new pagamentoDTO();
        pagamentoDTO.setIdcredor(pagamento.getCredor().getIdcredor());
        pagamentoDTO.setIdentedevedor(pagamento.getEntedevedor().getIdentedevedor() );
        pagamentoDTO.setId(pagamento.getId());
        pagamentoDTO.setRemessa(pagamento.getRemessa());
        pagamentoDTO.setValorinicial(pagamento.getValorinicial());
        pagamentoDTO.setValorinicial(pagamento.getValorfinal());
           
        return pagamentoDTO;   
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pagamento> obter(@PathVariable Long id) {
        Optional<Pagamento> pagamento = pagamanetoRepository.findById(id);
        
        if(pagamento.isPresent()){
            return ResponseEntity.ok(pagamento.get());
        }
        return ResponseEntity.notFound().build();
    }
   

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public retornoPagementoDTO adicionar(@RequestBody pagamentoDTO pagamento) { 
        
        Pagamento p = new Pagamento();
        
        p.setCredor(credorRepository.getById(pagamento.getIdcredor()));
        p.setEntedevedor(enteDevedorRepository.getById(pagamento.getIdentedevedor()));
        p.setRemessa(pagamento.getRemessa());
        p.setValorinicial(pagamento.getValorinicial());
        p.setValorfinal(pagamento.getValorfinal());
        p.setData(pagamento.getData());
        p.setId(pagamento.getId());
   
        p.setStatus("aprovado");
        
        if (!p.getCredor().getStatus().equals("aprovado")) {  
            p.setStatus("reprovado");
            p.setMotivo("credor não está aprovado");
        }
           
        if(p.getEntedevedor() == null) {
            
            p.setStatus("reprovado");
            p.setMotivo("ente devedor não encontrado");
        }    
        
        if (p.getValorinicial() <= 0 || p.getValorfinal() <= 0 ) {
            p.setStatus("reprovado");
            p.setMotivo("valor inicial ou final não pode ser igual a 0");    
        }
        
        if(p.getValorfinal() > p.getValorinicial()  ){
            p.setStatus("reprovado");
            p.setMotivo("O valor final deve ser sempre menor que o valor inicial");
        }
        
        pagamanetoRepository.save(p);
        return new retornoPagementoDTO(p.getId(), p.getMotivo(), p.getStatus());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Pagamento> update(@PathVariable Long id, @Validated @RequestBody pagamentoDTO pagamento){
        Optional<Pagamento> pagamentoAtual = pagamanetoRepository.findById(id);
        
        if(pagamentoAtual.isPresent()) {
            BeanUtils.copyProperties(pagamento, pagamentoAtual.get(), "id");
            Pagamento pagamentoSalvo = pagamanetoRepository.save(pagamentoAtual.get());
             
            return ResponseEntity.ok(pagamentoSalvo);
        }
        return ResponseEntity.notFound().build();       
    }
     
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    
        if(pagamanetoRepository.existsById(id)) {
            pagamanetoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}

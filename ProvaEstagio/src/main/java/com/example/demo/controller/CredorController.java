/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Credor;
import com.example.demo.repository.CredorRepository;
import java.util.List;
import java.util.Optional;
import org.apache.coyote.http11.Http11AprProtocol;
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
@RequestMapping("/credor")
public class CredorController {
    
    @Autowired
    private CredorRepository credorRepository;
      
    @GetMapping
    public List<Credor> listar() {
        return credorRepository.findAll();    
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Credor> obter(@PathVariable Long id) {
        Optional<Credor> credor = credorRepository.findById(id);
        
        if(credor.isPresent()) {
            return ResponseEntity.ok(credor.get());
        }
        return ResponseEntity.notFound().build();      
    }
       
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Credor adicionar(@RequestBody Credor credor) {
        return credorRepository.save(credor);    
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Credor> update(@PathVariable Long id, @Validated @RequestBody Credor credor){
        Optional<Credor> credorAtual = credorRepository.findById(id);
        
        if(credorAtual.isPresent()) {
            BeanUtils.copyProperties(credor, credorAtual.get(), "id");
            Credor credorSalvo = credorRepository.save(credorAtual.get());
            return ResponseEntity.ok(credorSalvo);
            
        }
        return ResponseEntity.notFound().build();      
    }
      
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        if(credorRepository.existsById(id)){
            credorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();      
    }    
}

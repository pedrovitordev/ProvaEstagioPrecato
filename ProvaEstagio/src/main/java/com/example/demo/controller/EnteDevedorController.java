/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.model.Credor;
import com.example.demo.model.EnteDevedor;
import com.example.demo.repository.EnteDevedorRepository;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/entedevedor")
public class EnteDevedorController {
    
    @Autowired
    private EnteDevedorRepository  enteDevedorRepository;
    
    @GetMapping
    public List<EnteDevedor> listar() {
        return enteDevedorRepository.findAll();    
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EnteDevedor> obter(@PathVariable Long id) {
        Optional<EnteDevedor> enteDevedor = enteDevedorRepository.findById(id);
        
        if(enteDevedor.isPresent()) {
            return ResponseEntity.ok(enteDevedor.get());
        }
        return ResponseEntity.notFound().build();      
    }
       
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EnteDevedor adicionar(@RequestBody EnteDevedor entedevedor) {
        return enteDevedorRepository.save(entedevedor);    
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EnteDevedor> update(@PathVariable Long id, @Validated @RequestBody EnteDevedor entedevedor){
        Optional<EnteDevedor> enteDevedorAtual = enteDevedorRepository.findById(id);
        
        if(enteDevedorAtual.isPresent()) {
            BeanUtils.copyProperties(entedevedor, enteDevedorAtual.get(), "id");
            EnteDevedor enteDevedorSalvo = enteDevedorRepository.save(enteDevedorAtual.get());
            return ResponseEntity.ok(enteDevedorSalvo);
            
        }
        return ResponseEntity.notFound().build();      
    }
      
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        
        if(enteDevedorRepository.existsById(id)){
            enteDevedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();      
    }    
    
    
}

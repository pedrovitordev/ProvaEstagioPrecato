/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author PedroVitorDev
 */

@Entity
public class Credor {
    
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long idcredor;
    
    @NotNull
    public String nome;
    
    @NotNull
    public String cpf;
    
    @NotNull
    public String status; //Ativo ou desativado

    public Credor() {
    }

    public Credor(Long idcredor, String nome, String cpf, String status) {
        this.idcredor = idcredor;
        this.nome = nome;
        this.cpf = cpf;
        this.status = status;
    }

    public Long getIdcredor() {
        return idcredor;
    }

    public void setIdcredor(Long idcredor) {
        this.idcredor = idcredor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
    
    
    
}

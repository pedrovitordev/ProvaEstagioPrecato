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
public class EnteDevedor {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long identedevedor;
    
    @NotNull
    public String nomeentedevedor;
    
    @NotNull
    public String cpf;

    public EnteDevedor() {
    }

    public EnteDevedor(Long identedevedor, String nomeentedevedor, String cpf) {
        this.identedevedor = identedevedor;
        this.nomeentedevedor = nomeentedevedor;
        this.cpf = cpf;
    }

    public Long getIdentedevedor() {
        return identedevedor;
    }

    public void setIdentedevedor(Long identedevedor) {
        this.identedevedor = identedevedor;
    }

    public String getNomeentedevedor() {
        return nomeentedevedor;
    }

    public void setNomeentedevedor(String nomeentedevedor) {
        this.nomeentedevedor = nomeentedevedor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

   
   
    
}

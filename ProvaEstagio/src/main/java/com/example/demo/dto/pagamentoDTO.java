/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;

import com.example.demo.model.Pagamento;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PedroVitorDev
 */
public class pagamentoDTO implements Serializable{
    
    public Long id; //IdRemessa
    
    private Long idcredor;

    private Long identedevedor;
    
    private double valorinicial;
    
    private double valorfinal;
    
    private Date data;

    private String remessa;
    
    public pagamentoDTO() {
    }

    public pagamentoDTO(Long id, Long idcredor, Long identedevedor, double valorinicial, double valorfinal, Date data, String remessa) {
        this.id = id;
        this.idcredor = idcredor;
        this.identedevedor = identedevedor;
        this.valorinicial = valorinicial;
        this.valorfinal = valorfinal;
        this.data = data;
        this.remessa = remessa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcredor() {
        return idcredor;
    }

    public void setIdcredor(Long idcredor) {
        this.idcredor = idcredor;
    }

    public Long getIdentedevedor() {
        return identedevedor;
    }

    public void setIdentedevedor(Long identedevedor) {
        this.identedevedor = identedevedor;
    }

    public double getValorinicial() {
        return valorinicial;
    }

    public void setValorinicial(double valorinicial) {
        this.valorinicial = valorinicial;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRemessa() {
        return remessa;
    }

    public void setRemessa(String remessa) {
        this.remessa = remessa;
    }

   
    
    

   
    
    
    
}

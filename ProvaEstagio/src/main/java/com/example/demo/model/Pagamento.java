/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import com.sun.istack.NotNull;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author PedroVitorDev
 */

@Entity
public class Pagamento {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id; 
    
    @JoinColumn(name = "idcredor", referencedColumnName = "idcredor")
    @ManyToOne(optional = true)
    private Credor credor;
    
    @JoinColumn(name = "identedevedor", referencedColumnName = "identedevedor")
    @ManyToOne(optional = true)
    private EnteDevedor entedevedor;
    
    @NotNull
    public double valorinicial;
    
    @NotNull
    public double valorfinal;
    
    @Temporal(TemporalType.DATE)
    public Date data;
    
    private String status;
    
    @NotNull
    public String remessa;
    
    public String motivo;

    public Pagamento() {
    }

    public Pagamento(Long id, Credor credor, EnteDevedor entedevedor, double valorinicial, double valorfinal, Date data, String status, String remessa, String motivo) {
        this.id = id;
        this.credor = credor;
        this.entedevedor = entedevedor;
        this.valorinicial = valorinicial;
        this.valorfinal = valorfinal;
        this.data = data;
        this.status = status;
        this.remessa = remessa;
        this.motivo = motivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Credor getCredor() {
        return credor;
    }

    public void setCredor(Credor credor) {
        this.credor = credor;
    }

    public EnteDevedor getEntedevedor() {
        return entedevedor;
    }

    public void setEntedevedor(EnteDevedor entedevedor) {
        this.entedevedor = entedevedor;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemessa() {
        return remessa;
    }

    public void setRemessa(String remessa) {
        this.remessa = remessa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    
    

    
    
    
   
    
}

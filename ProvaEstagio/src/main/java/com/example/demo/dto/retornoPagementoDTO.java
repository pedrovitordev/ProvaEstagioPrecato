/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.dto;

/**
 *
 * @author PedroVitorDev
 */
public class retornoPagementoDTO {
    
    private Long id;
    private String motivo;
    private String status;

    public retornoPagementoDTO() {
    }

    public retornoPagementoDTO(Long id, String motivo, String status) {
        this.id = id;
        this.motivo = motivo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
    
    
    
}

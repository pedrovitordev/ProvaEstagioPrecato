/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author PedroVitorDev
 */

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
}

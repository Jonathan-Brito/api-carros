package com.brito.carro.dto;

import com.brito.carro.domain.Carro;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarroDTO {

    private Long id;
    private String nome;
    private String tipo;

    public static CarroDTO create(Carro carro){
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(carro, CarroDTO.class);
    }
}

package com.brito.carro.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "carro")
public class Carro {

    @Id // Indica que esse campo é a chave primária na tabela carro
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Atributo Id vai ser auto incrementado pela JPA
    private Long id;

    // se o atributo nome fosse diferente da tabela fariamos @Column(name = "nome")
    private String nome;

    private String tipo;
    private String descricao;
    //private String urlFoto;
    //private String urlVideo;
    //private String latitude;
    //private String longitude;

}
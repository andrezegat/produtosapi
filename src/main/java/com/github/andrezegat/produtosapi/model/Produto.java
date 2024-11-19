package com.github.andrezegat.produtosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    private String id;
    private String nome;
    private String descricao;
    private Double preco;


}

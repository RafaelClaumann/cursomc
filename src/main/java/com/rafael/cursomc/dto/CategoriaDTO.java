package com.rafael.cursomc.dto;

import com.rafael.cursomc.domain.Categoria;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Nome não pode estar vazio!")
    @Length(min = 5, max = 80, message = "Nome deve ter pelo menos 5 caracteres e no máximo 80!")
    private String nome;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

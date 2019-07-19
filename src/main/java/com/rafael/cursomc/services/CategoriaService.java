package com.rafael.cursomc.services;

import com.rafael.cursomc.domain.Categoria;
import com.rafael.cursomc.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Classe para representar o servico capaz de atender o controlador REST relacionado a operacoes com Categoria.
@Service
public class CategoriaService {


    // A dependencia é automaticamente instanciada pelo Spring, pelo mecanismo de Injeção de Dependencia.
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElse(null);
    }
}

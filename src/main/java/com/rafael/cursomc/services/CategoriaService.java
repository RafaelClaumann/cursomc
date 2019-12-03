package com.rafael.cursomc.services;

import com.rafael.cursomc.domain.Categoria;
import com.rafael.cursomc.dto.CategoriaDTO;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.services.exceptions.DataIntegrityException;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Classe para representar o servico capaz de atender o controlador REST relacionado a operacoes com Categoria.
@Service
public class CategoriaService {


    // A dependencia é automaticamente instanciada pelo Spring, mecanismo de Injeção de Dependencia.
    @Autowired
    private CategoriaRepository categoriaRepository;

    /*
     * @ObjectNotFoundException from com.rafael.cursomc.services.exceptions
     * */
    public Categoria find(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + id + ", tipo: " + Categoria.class.getName()
        ));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos.");
        }
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDto(CategoriaDTO objDto) {
        return new Categoria(objDto.getId(), objDto.getNome());
    }
}

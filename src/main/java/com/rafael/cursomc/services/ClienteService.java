package com.rafael.cursomc.services;

import com.rafael.cursomc.domain.Cliente;
import com.rafael.cursomc.repositories.ClienteRepository;
import com.rafael.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado! id: " + id + ", tipo: " + Cliente.class.getName()
        ));
    }
}

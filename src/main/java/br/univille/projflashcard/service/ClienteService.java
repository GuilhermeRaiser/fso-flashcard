package br.univille.projflashcard.service;

import java.util.List;

import br.univille.projflashcard.entity.Cliente;

public interface ClienteService {

    void save(Cliente cliente);
    Cliente getById (long id);
    List<Cliente> getAll();
    Cliente delete (long id);

    
}

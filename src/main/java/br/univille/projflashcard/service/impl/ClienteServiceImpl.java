package br.univille.projflashcard.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projflashcard.entity.Cliente;
import br.univille.projflashcard.repository.ClienteRepository;
import br.univille.projflashcard.service.ClienteService;

@Service
public class ClienteServiceImpl 
    implements ClienteService {
    
    @Autowired
    private ClienteRepository repository;
        


    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public Cliente getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    @Override
    public Cliente delete(long id) {
        // TODO Auto-generated method stub
        var cliente = getById(id);
        repository.deleteById(id);
        return cliente;
    }


}

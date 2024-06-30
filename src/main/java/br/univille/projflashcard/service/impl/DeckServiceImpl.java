package br.univille.projflashcard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projflashcard.entity.Deck;
import br.univille.projflashcard.repository.DeckRepository;
import br.univille.projflashcard.service.DeckService;

@Service
public class DeckServiceImpl 
    implements DeckService {
    
    @Autowired
    private DeckRepository repository;
        


    @Override
    public void save(Deck deck) {
        repository.save(deck);
    }

    @Override
    public Deck getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Deck> getAll() {
        return repository.findAll();
    }

    @Override
    public Deck delete(long id) {
        // TODO Auto-generated method stub
        var deck = getById(id);
        repository.deleteById(id);
        return deck;
    }
}
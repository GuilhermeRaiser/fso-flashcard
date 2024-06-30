package br.univille.projflashcard.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projflashcard.entity.Card;
import br.univille.projflashcard.repository.CardRepository;
import br.univille.projflashcard.service.CardService;


@Service
public class CardServiceImpl 
    implements CardService {
    
    @Autowired
    private CardRepository repository;
        
    @Override
    public void save(Card card) {
        repository.save(card);
    }

    @Override
    public Card getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Card> getAll() {
        return repository.findAll();
    }

    @Override
    public Card delete(long id) {
        // TODO Auto-generated method stub
        var card = getById(id);
        repository.deleteById(id);
        return card;
}
}
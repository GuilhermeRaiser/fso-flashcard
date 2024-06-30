package br.univille.projflashcard.service;

import java.util.List;
import br.univille.projflashcard.entity.Card;


public interface CardService {
    
    void save(Card card);
    Card getById (long id);
    List<Card> getAll();
    Card delete (long id);
    
} 



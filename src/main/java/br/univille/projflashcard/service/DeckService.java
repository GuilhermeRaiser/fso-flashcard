package br.univille.projflashcard.service;

import java.util.List;

import br.univille.projflashcard.entity.Deck;

public interface DeckService {

    void save(Deck deck);
    Deck getById (long id);
    List<Deck> getAll();
    Deck delete (long id);

    
}
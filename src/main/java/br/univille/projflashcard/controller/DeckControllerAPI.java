package br.univille.projflashcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.projflashcard.entity.Deck;
import br.univille.projflashcard.service.DeckService;


@RestController
@RequestMapping("/api/v1/deck")
public class DeckControllerAPI {
    @Autowired
    private DeckService service;
    @GetMapping
    public ResponseEntity<List<Deck>> getDeck(){
        var listaDeck = service.getAll();
        return new ResponseEntity<List<Deck>> (listaDeck, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deck> post(@RequestBody Deck deck){
        if(deck.getId() == 0){
            service.save(deck);
            return new ResponseEntity<Deck>(deck, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Deck> put(@PathVariable long id,
                                    @RequestBody Deck deck){
        var deckAntigo = service.getById(id);
        if(deckAntigo == null){
            return ResponseEntity.notFound().build();
        }

        deckAntigo.setDeckNome(deck.getDeckNome());
        

        service.save(deckAntigo);
        return new ResponseEntity<Deck>(deckAntigo, HttpStatus.OK);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<Deck> delete(@PathVariable long id){
        var deck = service.getById(id);
        if(deck == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Deck>(deck,HttpStatus.OK);
    }











}

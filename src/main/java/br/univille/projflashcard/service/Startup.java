package br.univille.projflashcard.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projflashcard.entity.Card;
import br.univille.projflashcard.entity.Cliente;
import br.univille.projflashcard.entity.Deck;




@Component
public class Startup {

    @Autowired
    private ClienteService service;
    @Autowired
    private DeckService deckService;
    private CardService cardService;
    
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho");
        cliente1.setDataNascimento(new Date());
        service.save(cliente1);
    }
    public void onApplicationEvent2(ContextRefreshedEvent event){
    var deck1 = new Deck();
        deck1.setDeckNome("Espanhol");
        deckService.save(deck1);
    }
    public void onApplicationEvent3(ContextRefreshedEvent event){
        var card = new Card();
            card.setAddnomeDeck("Espanhol");
            card.setTitulo("Buenas noches");
            card.setTextoFrente("Buenas noches, como vá?");
            cardService.save(card);
    }
 }

package br.univille.projflashcard.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.projflashcard.entity.Card;
import br.univille.projflashcard.service.CardService;



@RestController
@RequestMapping("/api/v1/card")
public class CardControllerAPI {
    @Autowired
    private CardService service;
    @GetMapping
    public ResponseEntity<List<Card>> getCard(){
        var listaCard = service.getAll();
        return new ResponseEntity<List<Card>> (listaCard, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Card> post(@RequestBody Card card){
        if(card.getId() == 0){
            service.save(card);
            return new ResponseEntity<Card>(card, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Card> put(@PathVariable long id,
                                    @RequestBody Card card){
        var cardAntigo = service.getById(id);
        if(cardAntigo == null){
            return ResponseEntity.notFound().build();
        }

        cardAntigo.setAddnomeDeck(card.getAddnomeDeck());
        
        service.save(cardAntigo);
        return new ResponseEntity<Card>(cardAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Card> delete(@PathVariable long id){
        var card = service.getById(id);
        if(card == null){
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return new ResponseEntity<Card>(card,HttpStatus.OK);
    }
}

package br.univille.projflashcard.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Card {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000,nullable =false)
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String addnomeDeck;
    private String titulo;
    private String textoFrente;
    private String textoVerso;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getAddnomeDeck() {
        return addnomeDeck;
    }
    public void setAddnomeDeck(String addnomeDeck) {
        this.addnomeDeck = addnomeDeck;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTextoFrente() {
        return textoFrente;
    }
    public void setTextoFrente(String textoFrente) {
        this.textoFrente = textoFrente;
    }
    public String getTextoVerso() {
        return textoVerso;
    }
    public void setTextoVerso(String textoVerso) {
        this.textoVerso = textoVerso;
    }
    public void setDeckNome(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDeckNome'");
    }

    
}

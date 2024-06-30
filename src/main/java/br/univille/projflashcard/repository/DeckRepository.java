package br.univille.projflashcard.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projflashcard.entity.Deck;

@Repository
public interface DeckRepository extends JpaRepository<Deck,Long> {

}     
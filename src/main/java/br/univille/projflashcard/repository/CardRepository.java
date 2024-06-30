package br.univille.projflashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projflashcard.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    

    
}

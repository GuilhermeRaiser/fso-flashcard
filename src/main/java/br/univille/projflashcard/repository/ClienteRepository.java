package br.univille.projflashcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.projflashcard.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    

    
}

package com.jurgenvrapi.progettoS6D5.repositories;

import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    Dipendente findByUsername(String username);
    Optional<Dipendente> findByEmail(String email);
}


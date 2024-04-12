package com.jurgenvrapi.progettoS6D5.repositories;


import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import com.jurgenvrapi.progettoS6D5.entities.Dispositivo;
import com.jurgenvrapi.progettoS6D5.enums.StatoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, String> {
    List<Dispositivo> findByStato(StatoDispositivo stato);
    List<Dispositivo> findByDipendente(Dipendente dipendente);
}

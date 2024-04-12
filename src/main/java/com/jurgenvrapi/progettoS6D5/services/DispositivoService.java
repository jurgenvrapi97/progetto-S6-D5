package com.jurgenvrapi.progettoS6D5.services;

import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import com.jurgenvrapi.progettoS6D5.entities.Dispositivo;
import com.jurgenvrapi.progettoS6D5.exceptions.NotFoundException;
import com.jurgenvrapi.progettoS6D5.repositories.DipendenteRepository;
import com.jurgenvrapi.progettoS6D5.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dispositivo save(Dispositivo body) {
        return dispositivoRepository.save(body);
    }

    public Dispositivo findById(String id) {
        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(String id) {
        Dispositivo found = this.findById(id);
        dispositivoRepository.delete(found);
    }

    public Dispositivo findByIdAndUpdate(String id, Dispositivo body) {
        Dispositivo found = this.findById(id);
        found.setTipo(body.getTipo());
        found.setStato(body.getStato());
        return dispositivoRepository.save(found);
    }

    public Dispositivo assegnaDispositivo(Long idDipendente, String idDispositivo) {
        Dipendente dipendente = dipendenteRepository.findById(idDipendente)
                .orElseThrow(() -> new NotFoundException("Dipendente non trovato con ID: " + idDipendente));
        Dispositivo dispositivo = dispositivoRepository.findById(idDispositivo)
                .orElseThrow(() -> new NotFoundException("Dispositivo non trovato con ID: " + idDispositivo));

        dispositivo.setDipendente(dipendente);
        return dispositivoRepository.save(dispositivo);
    }
}

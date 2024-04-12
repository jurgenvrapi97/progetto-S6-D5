package com.jurgenvrapi.progettoS6D5.services;

import com.jurgenvrapi.progettoS6D5.entities.Dispositivo;
import com.jurgenvrapi.progettoS6D5.exceptions.NotFoundException;
import com.jurgenvrapi.progettoS6D5.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

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
}

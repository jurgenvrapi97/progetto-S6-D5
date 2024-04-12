package com.jurgenvrapi.progettoS6D5.services;

import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import com.jurgenvrapi.progettoS6D5.exceptions.BadRequestException;
import com.jurgenvrapi.progettoS6D5.exceptions.NotFoundException;
import com.jurgenvrapi.progettoS6D5.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Dipendente save(Dipendente body) {
        dipendenteRepository.findByEmail(body.getEmail()).ifPresent(user -> {
            throw new BadRequestException("L'email " + body.getEmail() + " è già stata utilizzata");
        });
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getNome().charAt(0) + "+" + body.getCognome().charAt(0));
        return dipendenteRepository.save(body);
    }


    public Dipendente findById(Long id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    public void findByIdAndDelete(Long id) {
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }

    public Dipendente findByIdAndUpdate(Long id, Dipendente body) {
        Dipendente found = this.findById(id);
        found.setEmail(body.getEmail());
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setAvatar(body.getAvatar());
        return dipendenteRepository.save(found);
    }
}


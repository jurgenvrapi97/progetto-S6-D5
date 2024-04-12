package com.jurgenvrapi.progettoS6D5.controllers;

import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import com.jurgenvrapi.progettoS6D5.exceptions.BadRequest;
import com.jurgenvrapi.progettoS6D5.payloads.DipendenteDTO;
import com.jurgenvrapi.progettoS6D5.services.DipendenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.validation.ObjectError;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@Valid @RequestBody DipendenteDTO dipendenteDTO, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequest(result.getAllErrors());
        }
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDTO.nome());
        dipendente.setCognome(dipendenteDTO.cognome());
        dipendente.setUsername(dipendenteDTO.username());
        dipendente.setEmail(dipendenteDTO.email());

        return ResponseEntity.ok(dipendenteService.save(dipendente));
    }



    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @Valid @RequestBody DipendenteDTO dipendenteDTO, BindingResult result) {
        if (result.hasErrors()) {
            throw new BadRequest(result.getAllErrors());
        }
        Dipendente dipendente = new Dipendente();
        dipendente.setNome(dipendenteDTO.nome());
        dipendente.setCognome(dipendenteDTO.cognome());
        dipendente.setUsername(dipendenteDTO.username());
        dipendente.setEmail(dipendenteDTO.email());

        return ResponseEntity.ok(dipendenteService.findByIdAndUpdate(id, dipendente));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.findByIdAndDelete(id);
        return ResponseEntity.ok().build();
    }
}


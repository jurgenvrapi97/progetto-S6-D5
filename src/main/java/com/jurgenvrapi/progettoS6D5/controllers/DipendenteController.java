package com.jurgenvrapi.progettoS6D5.controllers;

import com.jurgenvrapi.progettoS6D5.entities.Dipendente;
import com.jurgenvrapi.progettoS6D5.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@RequestBody Dipendente dipendente) {
        return ResponseEntity.ok(dipendenteService.save(dipendente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        return ResponseEntity.ok(dipendenteService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        return ResponseEntity.ok(dipendenteService.findByIdAndUpdate(id, dipendente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.findByIdAndDelete(id);
        return ResponseEntity.ok().build();
    }
}


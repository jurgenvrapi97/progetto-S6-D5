package com.jurgenvrapi.progettoS6D5.controllers;

import com.jurgenvrapi.progettoS6D5.entities.Dispositivo;
import com.jurgenvrapi.progettoS6D5.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping
    public ResponseEntity<Dispositivo> createDispositivo(@RequestBody Dispositivo dispositivo) {
        return ResponseEntity.ok(dispositivoService.save(dispositivo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> getDispositivoById(@PathVariable String id) {
        return ResponseEntity.ok(dispositivoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> updateDispositivo(@PathVariable String id, @RequestBody Dispositivo dispositivo) {
        return ResponseEntity.ok(dispositivoService.findByIdAndUpdate(id, dispositivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable String id) {
        dispositivoService.findByIdAndDelete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idDispositivo}/link/{idDipendente}")
    public ResponseEntity<Dispositivo> assegnaDispositivo(@PathVariable Long idDipendente, @PathVariable String idDispositivo) {
        return ResponseEntity.ok(dispositivoService.assegnaDispositivo(idDipendente, idDispositivo));
    }
}


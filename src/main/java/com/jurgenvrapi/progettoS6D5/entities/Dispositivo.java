package com.jurgenvrapi.progettoS6D5.entities;

import com.jurgenvrapi.progettoS6D5.enums.StatoDispositivo;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dispositivi")
public class Dispositivo {

    @Id
    private String id;
    private String tipo;

    @Enumerated(EnumType.STRING)
    private StatoDispositivo stato;


    @ManyToOne
    @JoinColumn(name = "id_dipendente")
    private Dipendente dipendente;
}
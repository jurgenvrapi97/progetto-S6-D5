package com.jurgenvrapi.progettoS6D5.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CascadeType;

import java.util.Set;

@Data
@Entity
@Table(name = "dipendenti")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String avatar;

    @OneToMany(mappedBy = "dipendente")
    private Set<Dispositivo> dispositivi;
}


package com.example.Gestione_Prenotazioni.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;

@Entity
@Data
public class Utente {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String username;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String email;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;
}

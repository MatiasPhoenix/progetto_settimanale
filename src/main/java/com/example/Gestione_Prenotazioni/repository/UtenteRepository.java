package com.example.Gestione_Prenotazioni.repository;

import com.example.Gestione_Prenotazioni.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}

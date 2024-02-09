package com.example.Gestione_Prenotazioni.repository;

import com.example.Gestione_Prenotazioni.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
}

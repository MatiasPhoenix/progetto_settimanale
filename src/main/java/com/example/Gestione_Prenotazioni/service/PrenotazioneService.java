package com.example.Gestione_Prenotazioni.service;

import com.example.Gestione_Prenotazioni.entity.Prenotazione;
import com.example.Gestione_Prenotazioni.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public void salvaPrenotazione(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public void aggiornaPrenotazione(Prenotazione prenotazione){
        Prenotazione i = prenotazioneRepository.findById(prenotazione.getId()).get();
        i.setDataPrenotazione(prenotazione.getDataPrenotazione());
        i.setPostazione(prenotazione.getPostazione());
        i.setUtente(prenotazione.getUtente());
        prenotazioneRepository.save(i);
    }

    public Prenotazione cercaPrenotazionePerId(int id){
        return prenotazioneRepository.findById(id).get();
    }

    public void cancellaPrenotazione(int id){
        prenotazioneRepository.deleteById(id);
    }
}

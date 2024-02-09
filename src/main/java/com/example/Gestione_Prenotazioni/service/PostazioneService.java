package com.example.Gestione_Prenotazioni.service;

import com.example.Gestione_Prenotazioni.entity.Postazione;
import com.example.Gestione_Prenotazioni.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public void salvaPostazione(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public void aggiornaPostazione(Postazione postazione){
        Postazione i = postazioneRepository.findById(postazione.getId()).get();
        i.setDescrizione(postazione.getDescrizione());
        i.setEdificio(postazione.getEdificio());
        i.setTipo(postazione.getTipo());
        i.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
        postazioneRepository.save(i);
    }

    public Postazione cercaPostazionePerId(int id){
        return postazioneRepository.findById(id).get();
    }

    public void cancellaPostazione(int id){
        postazioneRepository.deleteById(id);
    }
}

package com.example.Gestione_Prenotazioni;

import com.example.Gestione_Prenotazioni.entity.*;
import com.example.Gestione_Prenotazioni.service.EdificioService;
import com.example.Gestione_Prenotazioni.service.PostazioneService;
import com.example.Gestione_Prenotazioni.service.PrenotazioneService;
import com.example.Gestione_Prenotazioni.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    private Logger logger = LoggerFactory.getLogger("Gestione_Prenotazioni");

    @Override
    public void run(String... args) throws Exception {

        //dati edifici
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Luogo Bello");
        edificio1.setCitta("Camaiore");
        edificio1.setIndirizzo("TurismoTop");

        Edificio edificio2 = new Edificio();
        edificio2.setNome("Vicino a noi");
        edificio2.setCitta("Pisa");
        edificio2.setIndirizzo("Torre Inclinata");

        edificioService.salvaEdificio(edificio1);
        edificioService.salvaEdificio(edificio2);

        //dati utenti
        Utente utente1 = new Utente();
        utente1.setNomeCompleto("Giulio Cesare");
        utente1.setEmail("romainvicta@spqr.com");

        Utente utente2 = new Utente();
        utente2.setNomeCompleto("Alessandro Magno");
        utente2.setEmail("conquistatore@macedonia.com");

        utenteService.salvaUtente(utente1);
        utenteService.salvaUtente(utente2);

        //dati prenotazioni
        Postazione postazione1 = new Postazione();
        postazione1.setTipo(TipoPostazione.PRIVATO);
        postazione1.setDescrizione("Letto matrimoniale, Terrazzo con Angolo Bar, Idromassaggio");
        postazione1.setNumeroMassimoOccupanti(3);
        postazione1.setEdificio(edificio1);

        Postazione postazione2 = new Postazione();
        postazione2.setTipo(TipoPostazione.OPENSPACE);
        postazione2.setDescrizione("Palco, Sala Conferenze, Angolo Bar");
        postazione2.setNumeroMassimoOccupanti(80);
        postazione2.setEdificio(edificio1);

        Postazione postazione3 = new Postazione();
        postazione3.setTipo(TipoPostazione.SALA_RIUNIONI);
        postazione3.setDescrizione("Proiettore, Posti a Sedere, Tavolo Riunioni");
        postazione3.setNumeroMassimoOccupanti(15);
        postazione3.setEdificio(edificio1);


        Prenotazione prenotazione1 = new Prenotazione(postazione1, utente2);
        Prenotazione prenotazione2 = new Prenotazione(postazione3, utente1);


        postazioneService.salvaPostazione(postazione1);
        postazioneService.salvaPostazione(postazione3);
        prenotazioneService.salvaPrenotazione(prenotazione1);
        prenotazioneService.salvaPrenotazione(prenotazione2);

        logger.info(utente1.toString());
        logger.info(utente2.toString());
    }
}

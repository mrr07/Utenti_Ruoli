package it.manytomanyjpamaven.service;

import java.util.List;

import it.manytomanyjpamaven.dao.UtenteDAO;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;

public interface UtenteService  {
	
	public List<Utente> listAll() throws Exception;

	public Utente caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Utente utenteInstance) throws Exception;

	public void inserisciNuovo(Utente utenteInstance) throws Exception;

	public void rimuovi(Utente utenteInstance) throws Exception;
	
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;
	
	public void rimuoviRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;
	
	public boolean esisteUtenteConUsername(Utente utente) throws Exception;
	
	public List<Utente> listAllByRuolo(Ruolo ruolo) throws Exception;
 
	public Utente findByUsername(Utente utente) throws Exception;
	
	public int setStatoUtente(Utente utente, StatoUtente stato) throws Exception;
	
	//per injection
	public void setUtenteDAO(UtenteDAO utenteDAO);

}

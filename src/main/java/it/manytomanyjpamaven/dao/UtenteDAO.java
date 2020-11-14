package it.manytomanyjpamaven.dao;

import java.util.List;

import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {
	
	public List<Utente> findAllByRuolo(Ruolo ruoloInput) throws Exception;
	
	public boolean existByUsername(Utente utente) throws Exception;
	
	public Utente findByUsername(Utente utente) throws Exception;
	
	public int setStatoUtente(Utente utente, StatoUtente stato) throws Exception;

}

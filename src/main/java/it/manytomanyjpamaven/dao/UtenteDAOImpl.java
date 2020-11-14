package it.manytomanyjpamaven.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;


public class UtenteDAOImpl implements UtenteDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Utente> list() throws Exception {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Utente",Utente.class).getResultList();
	}

	@Override
	public Utente get(Long id) throws Exception {
		return entityManager.find(Utente.class, id);
	}

	@Override
	public void update(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		utenteInstance = entityManager.merge(utenteInstance);
	}

	@Override
	public void insert(Utente utenteInstance) throws Exception {
		if (utenteInstance == null || existByUsername(utenteInstance)) {
			throw new Exception("Problema valore in input");
		}
		
		entityManager.persist(utenteInstance);
	}

	@Override
	public void delete(Utente utenteInstance) throws Exception {
		if (utenteInstance == null) {
			throw new Exception("Problema valore in input");
		}
		
		entityManager.remove(entityManager.merge(utenteInstance));
	}

	// questo metodo ci torna utile per capire se possiamo rimuovere un ruolo non
	// essendo collegato ad un utente
	public List<Utente> findAllByRuolo(Ruolo ruoloInput) throws Exception{
		TypedQuery<Utente> query = entityManager.createQuery("select u FROM Utente u join u.ruoli r where r = :ruolo",Utente.class);
		query.setParameter("ruolo", ruoloInput);
		return query.getResultList();
	}
	
	
	@Override
	public boolean existByUsername(Utente utente) throws Exception {
		
		List<Utente> listaUtenti = new ArrayList<>();
		listaUtenti = list();
		
		for(Utente ut : listaUtenti) {
			if(utente.getUsername().compareTo(ut.getUsername()) == 0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Utente findByUsername(Utente utente) throws Exception {
		
		TypedQuery<Utente> query = entityManager.createQuery("select u FROM Utente u where u.username = ?1",Utente.class);
		query.setParameter(1, utente.getUsername());
		return query.getSingleResult();
	
		
	}

	@Override
	public int setStatoUtente(Utente utente, StatoUtente stato) throws Exception {
		
			Utente utenteDaAggiornare = findByUsername(utente);
			utenteDaAggiornare.setStato(stato);
			update(utenteDaAggiornare);
			return 1;
			
	}

	

	

}

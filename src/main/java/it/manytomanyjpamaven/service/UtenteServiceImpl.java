package it.manytomanyjpamaven.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.dao.UtenteDAO;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;

public class UtenteServiceImpl implements UtenteService {

	private UtenteDAO utenteDAO;

	@Override
	public void setUtenteDAO(UtenteDAO utenteDAO) {
		this.utenteDAO = utenteDAO;
	}

	@Override
	public List<Utente> listAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return utenteDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public Utente caricaSingoloElemento(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return utenteDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void aggiorna(Utente utenteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			utenteDAO.update(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			utenteDAO.insert(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void rimuovi(Utente utenteInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			utenteDAO.delete(utenteInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quel ruolo non deve essere inserito
			utenteEsistente = entityManager.merge(utenteEsistente);
			ruoloInstance = entityManager.merge(ruoloInstance);
			
			utenteEsistente.getRuoli().add(ruoloInstance);
			//l'update non viene richiamato a mano in quanto 
			//risulta automatico, infatti il contesto di persistenza
			//rileva che utenteEsistente ora è dirty vale a dire che una sua
			//proprieta ha subito una modifica (vale anche per i Set ovviamente)

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public void rimuoviRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// 'attacco' alla sessione di hibernate i due oggetti
			// così jpa capisce che se è già presente quel ruolo non deve essere inserito
			utenteEsistente = entityManager.merge(utenteEsistente);
			ruoloInstance = entityManager.merge(ruoloInstance);
			
			utenteEsistente.getRuoli().remove(ruoloInstance);
			//l'update non viene richiamato a mano in quanto 
			//risulta automatico, infatti il contesto di persistenza
			//rileva che utenteEsistente ora è dirty vale a dire che una sua
			//proprieta ha subito una modifica (vale anche per i Set ovviamente)

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}

	}
	
	@Override
	public boolean esisteUtenteConUsername(Utente utente) throws Exception{
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			utenteDAO.setEntityManager(entityManager);
			
			if(utenteDAO.existByUsername(utente)) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Utente> listAllByRuolo(Ruolo ruolo) throws Exception{
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return utenteDAO.findAllByRuolo(ruolo);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}
	
	@Override
	public Utente findByUsername(Utente utente) throws Exception{
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			utenteDAO.setEntityManager(entityManager);
			
			// eseguo quello che realmente devo fare
			return utenteDAO.findByUsername(utente);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
	}

	@Override
	public int setStatoUtente(Utente utente, StatoUtente stato) throws Exception {
			// questo è come una connection
			EntityManager entityManager = EntityManagerUtil.getEntityManager();

			try {
				// questo è come il MyConnection.getConnection()
				entityManager.getTransaction().begin();

				// uso l'injection per il dao
				utenteDAO.setEntityManager(entityManager);

				// eseguo quello che realmente devo fare
				utenteDAO.setStatoUtente(utente, stato);

				entityManager.getTransaction().commit();
				return 1;
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				throw e;
			}

		}
	}


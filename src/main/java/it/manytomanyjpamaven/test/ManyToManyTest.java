package it.manytomanyjpamaven.test;

import java.util.Date;
import java.util.List;

import it.manytomanyjpamaven.dao.EntityManagerUtil;
import it.manytomanyjpamaven.model.Ruolo;
import it.manytomanyjpamaven.model.StatoUtente;
import it.manytomanyjpamaven.model.Utente;
import it.manytomanyjpamaven.service.MyServiceFactory;
import it.manytomanyjpamaven.service.RuoloService;
import it.manytomanyjpamaven.service.UtenteService;

@SuppressWarnings("unused")

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			// inizializzo i ruoli sul db
			initRuoli(ruoloServiceInstance);

			// -------- STAMPO TUTTI GLI UTENTI SUL DB ---------
			
			/*
			System.out.println("ELENCO DI TUTTI GLI UTENTI NEL DB: ");
			for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
			}
			System.out.println("");
			*/
			
			// -------CREAZIONE UTENTI -----------
			
			Utente utente1 = new Utente("pippo.rossi", "xxx", "pippo", "rossi", new Date());
			Utente utente2 = new Utente("pino.selvaggio", "xxxx", "pino", "selvaggio", new Date());			
			Utente utente3 = new Utente("rino.gattuso", "xxx", "rino", "gattuso", new Date());
			Utente utente4 = new Utente("carlo.menni", "xxx", "carlo", "menni", new Date());
			Utente utente5 = new Utente("mario.panchi", "xxx", "mario", "panchi", new Date());
			Utente utente6 = new Utente("rin.gattuso", "xxx", "nome", "cognome", new Date());
			
			// --------- INSERISCO GLI UTENTI CREATI NEL DB ---------------------
			
			/*
			utenteServiceInstance.inserisciNuovo(utente1);
			utenteServiceInstance.inserisciNuovo(utente2);
			utenteServiceInstance.inserisciNuovo(utente3);
			utenteServiceInstance.inserisciNuovo(utente4);
			utenteServiceInstance.inserisciNuovo(utente5);
			utenteServiceInstance.inserisciNuovo(utente6);		se provo a inserire questo utente nel DB ho un errore perché già presente
			*/
			
			
			
			// ---------- IMPOSTO IL RUOLO DEGLI UTENTI CREATI -----------------
			
			
			Ruolo amministratore = ruoloServiceInstance.caricaSingoloElemento(1L);
			Ruolo utenteClassico = ruoloServiceInstance.caricaSingoloElemento(2L);
			
			/*
			utenteServiceInstance.aggiungiRuolo(utente1 , amministratore);
			utenteServiceInstance.aggiungiRuolo(utente2 , amministratore);
			utenteServiceInstance.aggiungiRuolo(utente3 , utenteClassico);
			utenteServiceInstance.aggiungiRuolo(utente4 , utenteClassico);
			utenteServiceInstance.aggiungiRuolo(utente5 , utenteClassico);
			utenteServiceInstance.aggiungiRuolo(utente1 , utenteClassico);
			*/

			// --------- PROVO AD ELIMINARE I RUOLI ---------------
			
			/*
			 * non posso eliminare i ruoli finché non dissocio gli utenti 
			 * dal ruolo che voglio eliminare
			 * entrambi i metodi restituiscono un messaggio con gli utenti 
			 * che hanno il ruolo che si vuole eliminare
			 */
			
			/*
			ruoloServiceInstance.rimuovi(utenteClassico);
			ruoloServiceInstance.rimuovi(amministratore);
			*/
			
			
			// ---------- ELIMINO UN UTENTE -------------
			
			/*
			 * prelevo dal DB sia l'utente che voglio eliminare ma anche il ruolo o i ruoli 
			 * associati a quell'utente
			 */
			
			/*
			Utente utente = utenteServiceInstance.caricaSingoloElemento(2L);
			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(1L);
 			*/
			
			
			/*
			 * rimuovo prima i ruoli nella tabella associativa e poi l'utente
			 */
			
			/*
			utenteServiceInstance.rimuoviRuolo(utente, ruoloDaDb);
			utenteServiceInstance.rimuovi(utente);
			*/
			
			/*
			 * L'ELIMINAZIONE NON VIENE PIU' EFFETTUATA CON IL METODO rimuovi MA BENSI' CON 
			 * IL CAMBIO DI STATO OVVERO SE L'UTENTE DEVE ESSERE ELIMINATO IL SUO STATO VIENE 
			 * SETTATO SU 'DISABILITATO'
			 */
			
			// ------------ CAMBIO DI STATO DEGLI UTENTI -----------------
			
			/*
			 * prendo dal DB gli utenti di cui voglio impostare lo stato
			 */
			
			/*
			Utente utenteDB1 = utenteServiceInstance.findByUsername(utente1);
			Utente utenteDB2 = utenteServiceInstance.findByUsername(utente2);
			Utente utenteDB3 = utenteServiceInstance.findByUsername(utente3);
			Utente utenteDB4 = utenteServiceInstance.findByUsername(utente4);
			Utente utenteDB5 = utenteServiceInstance.findByUsername(utente5);
			Utente utenteDB6 = utenteServiceInstance.findByUsername(utente6);
			*/
			
			/*
			 * setto lo stato degli oggetti
			 */
			
			/*
			utenteDB1.setStato(StatoUtente.ATTIVO);
			utenteDB2.setStato(StatoUtente.ATTIVO);
			utenteDB3.setStato(StatoUtente.ATTIVO);
			utenteDB4.setStato(StatoUtente.DISABILITATO); //questo è un utente "eliminato"
			utenteDB5.setStato(StatoUtente.ATTIVO);
			utenteDB6.setStato(StatoUtente.DISABILITATO);
			*/
			
			/*
			 * aggiorno i record del DB
			 */
			
			/*
			utenteServiceInstance.aggiorna(utenteDB1);
			utenteServiceInstance.aggiorna(utenteDB2);
			utenteServiceInstance.aggiorna(utenteDB3);
			utenteServiceInstance.aggiorna(utenteDB4);
			utenteServiceInstance.aggiorna(utenteDB5);
			utenteServiceInstance.aggiorna(utenteDB6);
			utenteServiceInstance.setStatoUtente(utente2, StatoUtente.DISABILITATO); //implementato il metodo che setta lo stato
			*/
			
			
//			------------------------------------------------------------------------------------------
			
			
//
//			Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(2L);
//			
//			int ultimoUtenteIns = utenteServiceInstance.listAll().size();
//
//			Utente utenteDaDb = utenteServiceInstance.listAll().stream().findFirst().orElse(null);
//			if (utenteDaDb != null) {
//				utenteServiceInstance.aggiungiRuolo(utenteDaDb, ruoloDaDb);
//			}
//			
			// proviamo a passarlo nello stato ATTIVO
			
//			Utente utenteDaDb2 = utenteServiceInstance.listAll().stream().findFirst().get();
//			if(utenteDaDb2.getStato().name() != "ATTIVO") {
//				if (utenteDaDb2 != null) {
//				System.out.println(
//						"stato attuale dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//				utenteDaDb2.setStato(StatoUtente.ATTIVO);
//				utenteServiceInstance.aggiorna(utenteDaDb2);
//				System.out.println(
//						"stato nuovo dell'utente :" + utenteDaDb2.getUsername() + " " + utenteDaDb2.getStato());
//				}
//			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// questa è necessaria per chiudere tutte le connessioni quindi rilasciare il
			// main
			EntityManagerUtil.shutdown();
		}

	}

	private static void initRuoli(RuoloService ruoloServiceInstance) throws Exception {
		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Administrator", "ROLE_ADMIN") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Administrator", "ROLE_ADMIN"));
		}

		if (ruoloServiceInstance.cercaPerDescrizioneECodice("Classic User", "ROLE_CLASSIC_USER") == null) {
			ruoloServiceInstance.inserisciNuovo(new Ruolo("Classic User", "ROLE_CLASSIC_USER"));
		}
	}

}

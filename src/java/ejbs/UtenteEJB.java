package ejbs;

import entities.Utente;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import managedbeans.UtenteMB;

@Stateful
public class UtenteEJB implements UtenteEJBLocal {

    @PersistenceContext(unitName = "FattureJpaPU")
    EntityManager em;
    
    @Override
    public boolean registraUtente(UtenteMB utenteMb) {
        
        Utente utente = new Utente();
        utente.setEmail(utenteMb.getEmail());
        utente.setNome(utenteMb.getNome());
        utente.setCognome(utenteMb.getCognome());
        utente.setCf(utenteMb.getCf());
        utente.setDatanascita(utenteMb.getDatanascita());
        utente.setPassword(utenteMb.getPassword());
        utente.setSesso(utenteMb.getSesso());
        
        em.persist(utente);
        return em.contains(utente);
    }

    

}

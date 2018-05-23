package ejbs;

import entities.Utente;
import java.time.Instant;
import java.util.Date; 
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import managedbeans.UtenteManagedBean;
        
@Stateful
public class UtenteEJB implements UtenteEJBLocal {

    @PersistenceContext(unitName = "FattureJpaPU")
    EntityManager em;

    private Utente utente = null;

    @Override
    public boolean registraUtente(UtenteManagedBean utenteMb) {

        Utente utente = new Utente();
        utente.setEmail(utenteMb.getEmail());
        utente.setNome(utenteMb.getNome());
        utente.setCognome(utenteMb.getCognome());
        utente.setCf(utenteMb.getCf());
        utente.setDatanascita(utenteMb.getDatanascita());
        utente.setPassword(utenteMb.getPassword());
        utente.setSesso(utenteMb.getSesso());
        utente.setDatacreazione(Date.from(Instant.now()));
        utente.setSale("efjwebfhwehifwe");

        try {
            em.persist(utente);
            em.flush();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return em.contains(utente);
    }

    @Override
    public Utente getByEmail(String email) {
        TypedQuery<Utente> utenti = em.createNamedQuery("Utente.findByEmail", Utente.class).setParameter("email", email);
        if (utenti.getResultList().isEmpty() == false) {
            return utenti.getSingleResult();
        } else {
            return null;
        }
    }

    @Override
    public Utente getUtente() {
        return utente;
    }

    @Override
    public boolean login(String email, String password) {
        Utente u = getByEmail(email);
        if (u != null && password.equals(u.getPassword())) {
            this.utente = u;
            return true;
        } else {
            return false;
        }

    }

}

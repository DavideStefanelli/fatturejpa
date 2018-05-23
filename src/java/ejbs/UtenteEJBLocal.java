package ejbs;

import entities.Utente;
import javax.ejb.Local;
import managedbeans.UtenteManagedBean;

@Local
public interface UtenteEJBLocal {
    
    public boolean registraUtente(UtenteManagedBean utenteMb);
    
    public Utente getByEmail(String email);
    
    public boolean login(String email, String password);
    
    public Utente getUtente();
}

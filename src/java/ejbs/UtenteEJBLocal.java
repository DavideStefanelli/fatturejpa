package ejbs;

import javax.ejb.Local;
import managedbeans.UtenteMB;

@Local
public interface UtenteEJBLocal {
    
    public boolean registraUtente(UtenteMB utenteMb);
    
}

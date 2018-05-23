package ejbs;

import entities.Societa;
import entities.Utente;
import javax.ejb.Local;
import managedbeans.SocietaManagedBean;

@Local
public interface SocietaEJBLocal {
    
    public boolean registra(SocietaManagedBean societa);
    public Societa getByPiva(String piva);
    public Societa getByUtente(Utente utente);
    
}

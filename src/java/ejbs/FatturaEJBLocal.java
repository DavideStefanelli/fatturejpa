package ejbs;

import entities.Fattura;
import java.util.List;
import javax.ejb.Local;
import managedbeans.FatturaManagedBean;

@Local
public interface FatturaEJBLocal {
    
    public boolean registra(FatturaManagedBean fattura, String pIvaSocieta);
    
    public List<Fattura> getByIdSocieta(int id);
    public List<Fattura> getAll();
    
}

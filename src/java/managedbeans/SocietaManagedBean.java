package managedbeans;

import ejbs.SocietaEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.validation.constraints.Size;


@Named(value = "societaManagedBean")
@RequestScoped
public class SocietaManagedBean implements Serializable {

    @Size(min = 3, max = 100)
    private String intestazione;
    
    @Size(min = 8, max = 16)
    private String cf;
    
    @Size(min = 11, max = 11)
    private String piva;
    
    private int ragsociale;
    
    @EJB
    SocietaEJBLocal societaEjb;
    
    public SocietaManagedBean() {
        
    }
    
    public String registra(){
        boolean insertOk = societaEjb.registra(this);
        if(insertOk){
            return "home.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    public String getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(String intestazione) {
        this.intestazione = intestazione;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public int getRagsociale() {
        return ragsociale;
    }

    public void setRagsociale(int ragsociale) {
        this.ragsociale = ragsociale;
    }
    
    
    
    
}

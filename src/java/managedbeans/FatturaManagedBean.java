package managedbeans;

import ejbs.FatturaEJBLocal;
import ejbs.SocietaEJBLocal;
import ejbs.UtenteEJBLocal;
import entities.Fattura;
import entities.Societa;
import entities.Utente;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@Named(value = "fatturaManagedBean")
@RequestScoped
public class FatturaManagedBean implements Serializable {

    @Size(min = 11, max = 11)
    private String piva;
  
    private float importo;
    private Date datapagamento;
    
    @EJB 
    FatturaEJBLocal fatturaEjb;
    
    @EJB
    SocietaEJBLocal societaEjb;
    
    List<Fattura> fatture;
    
    UtenteEJBLocal utenteEjb;
    
    public FatturaManagedBean() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session != null){
            utenteEjb = (UtenteEJBLocal)session.getAttribute("utenteEjb");
        }
    }

    public List<Fattura> getFatture() {
        int permessiUtente = utenteEjb.getUtente().getGroupid();
        switch(permessiUtente){
            case Utente.TipoUtente.CONTABILE:
                Societa societaGestita = societaEjb.getByUtente(utenteEjb.getUtente());
                if(societaGestita != null){
                    fatture = fatturaEjb.getByIdSocieta(societaGestita.getId()); 
                }
                break;
            case Utente.TipoUtente.AMMINISTRATORE:
                fatture = fatturaEjb.getAll();
                break;
        } 
        return fatture;
    }
    
    public String registra(){
        
        if(fatturaEjb.registra(this, piva)){
            return "success.xhtml";
        } else {
            return "error.xhtml";
        }
        
    }

    public String getPiva() {
        return piva;
    }

    public void setPiva(String piva) {
        this.piva = piva;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public Date getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(Date datapagamento) {
        this.datapagamento = datapagamento;
    }
    
    
    
}

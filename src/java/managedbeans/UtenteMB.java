package managedbeans;

import ejbs.UtenteEJBLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "utenteMB")
@Dependent
public class UtenteMB {

    private String email;
    private String nome;
    private String cognome;
    private String cf;
    private Date datanascita;
    private String password;
    private Character sesso;
    
    @EJB
    UtenteEJBLocal utenteEjb;
    
    public UtenteMB() {
        
    }
    
    public void registra(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Date getDatanascita() {
        return datanascita;
    }

    public void setDatanascita(Date datanascita) {
        this.datanascita = datanascita;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Character getSesso() {
        return sesso;
    }

    public void setSesso(Character sesso) {
        this.sesso = sesso;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejbs.UtenteEJBLocal;
import entities.Utente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

@Named(value = "utenteManagedBean")
@SessionScoped
public class UtenteManagedBean implements Serializable {
    
    @Size(min = 5, max = 75)
    private String email;
    
    @Size(min = 3, max = 45)
    private String nome;
    
    @Size(min = 3, max = 45)
    private String cognome;
    
    @Size(min = 8, max = 16)
    private String cf;
    
    @Size(min = 8, max = 16)
    private String password;
    
    private Character sesso;
    
    private Date datanascita;
    
    @EJB
    UtenteEJBLocal utenteEjb;
    
    public String registra(){
        boolean insertOk = utenteEjb.registraUtente(this);
        if(insertOk){
            return "login.xhtml";
        } else {
            return "error.xhtml";
        }
    }

    public String login(){

        if(utenteEjb.login(email, password) == true){
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("utenteEjb", utenteEjb); 
            return "home.xhtml";
        } else {
            return "login.xhtml";
        }
        
    }
    
    public String logout(){
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(session != null){
            session.invalidate();
        }
        return "login.xhtml";
    }
    
    public UtenteManagedBean() {
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

    public UtenteEJBLocal getUtenteEjb() {
        return utenteEjb;
    }

    public void setUtenteEjb(UtenteEJBLocal utenteEjb) {
        this.utenteEjb = utenteEjb;
    }
    
    
    
}

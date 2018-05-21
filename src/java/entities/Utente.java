/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author web4e
 */
@Entity
@Table(name = "utente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u"),
    @NamedQuery(name = "Utente.findById", query = "SELECT u FROM Utente u WHERE u.id = :id"),
    @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email"),
    @NamedQuery(name = "Utente.findByCf", query = "SELECT u FROM Utente u WHERE u.cf = :cf"),
    @NamedQuery(name = "Utente.findByNome", query = "SELECT u FROM Utente u WHERE u.nome = :nome"),
    @NamedQuery(name = "Utente.findByCognome", query = "SELECT u FROM Utente u WHERE u.cognome = :cognome"),
    @NamedQuery(name = "Utente.findByDatanascita", query = "SELECT u FROM Utente u WHERE u.datanascita = :datanascita"),
    @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password"),
    @NamedQuery(name = "Utente.findBySale", query = "SELECT u FROM Utente u WHERE u.sale = :sale"),
    @NamedQuery(name = "Utente.findByDatacreazione", query = "SELECT u FROM Utente u WHERE u.datacreazione = :datacreazione"),
    @NamedQuery(name = "Utente.findBySesso", query = "SELECT u FROM Utente u WHERE u.sesso = :sesso"),
    @NamedQuery(name = "Utente.findByGroupid", query = "SELECT u FROM Utente u WHERE u.groupid = :groupid")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cf")
    private String cf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datanascita")
    @Temporal(TemporalType.DATE)
    private Date datanascita;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sale")
    private String sale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datacreazione")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacreazione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sesso")
    private Character sesso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupid")
    private int groupid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contabile")
    private Collection<Societa> societaCollection;

    public Utente() {
    }

    public Utente(Integer id) {
        this.id = id;
    }

    public Utente(Integer id, String email, String cf, String nome, String cognome, Date datanascita, String password, String sale, Date datacreazione, Character sesso, int groupid) {
        this.id = id;
        this.email = email;
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.datanascita = datanascita;
        this.password = password;
        this.sale = sale;
        this.datacreazione = datacreazione;
        this.sesso = sesso;
        this.groupid = groupid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
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

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public Date getDatacreazione() {
        return datacreazione;
    }

    public void setDatacreazione(Date datacreazione) {
        this.datacreazione = datacreazione;
    }

    public Character getSesso() {
        return sesso;
    }

    public void setSesso(Character sesso) {
        this.sesso = sesso;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @XmlTransient
    public Collection<Societa> getSocietaCollection() {
        return societaCollection;
    }

    public void setSocietaCollection(Collection<Societa> societaCollection) {
        this.societaCollection = societaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Utente[ id=" + id + " ]";
    }
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "societa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Societa.findAll", query = "SELECT s FROM Societa s"),
    @NamedQuery(name = "Societa.findById", query = "SELECT s FROM Societa s WHERE s.id = :id"),
    @NamedQuery(name = "Societa.findByIntestazione", query = "SELECT s FROM Societa s WHERE s.intestazione = :intestazione"),
    @NamedQuery(name = "Societa.findByCf", query = "SELECT s FROM Societa s WHERE s.cf = :cf"),
    @NamedQuery(name = "Societa.findByPiva", query = "SELECT s FROM Societa s WHERE s.piva = :piva"),
    @NamedQuery(name = "Societa.findByRagsociale", query = "SELECT s FROM Societa s WHERE s.ragsociale = :ragsociale"),
    @NamedQuery(name = "Societa.findByDataregistrazione", query = "SELECT s FROM Societa s WHERE s.dataregistrazione = :dataregistrazione"),
    @NamedQuery(name = "Societa.findByDatachiusura", query = "SELECT s FROM Societa s WHERE s.datachiusura = :datachiusura")})
public class Societa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "intestazione")
    private String intestazione;
    @Size(max = 255)
    @Column(name = "cf")
    private String cf;
    @Size(max = 255)
    @Column(name = "piva")
    private String piva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ragsociale")
    private int ragsociale;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataregistrazione")
    @Temporal(TemporalType.DATE)
    private Date dataregistrazione;
    @Column(name = "datachiusura")
    @Temporal(TemporalType.DATE)
    private Date datachiusura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Fattura> fatturaCollection;
    @JoinColumn(name = "contabile", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Utente contabile;

    public Societa() {
    }

    public Societa(Integer id) {
        this.id = id;
    }

    public Societa(Integer id, String intestazione, int ragsociale, Date dataregistrazione) {
        this.id = id;
        this.intestazione = intestazione;
        this.ragsociale = ragsociale;
        this.dataregistrazione = dataregistrazione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDataregistrazione() {
        return dataregistrazione;
    }

    public void setDataregistrazione(Date dataregistrazione) {
        this.dataregistrazione = dataregistrazione;
    }

    public Date getDatachiusura() {
        return datachiusura;
    }

    public void setDatachiusura(Date datachiusura) {
        this.datachiusura = datachiusura;
    }

    @XmlTransient
    public Collection<Fattura> getFatturaCollection() {
        return fatturaCollection;
    }

    public void setFatturaCollection(Collection<Fattura> fatturaCollection) {
        this.fatturaCollection = fatturaCollection;
    }

    public Utente getContabile() {
        return contabile;
    }

    public void setContabile(Utente contabile) {
        this.contabile = contabile;
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
        if (!(object instanceof Societa)) {
            return false;
        }
        Societa other = (Societa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Societa[ id=" + id + " ]";
    }
    
}

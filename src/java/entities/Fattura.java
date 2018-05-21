/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author web4e
 */
@Entity
@Table(name = "fattura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fattura.findAll", query = "SELECT f FROM Fattura f"),
    @NamedQuery(name = "Fattura.findByCod", query = "SELECT f FROM Fattura f WHERE f.cod = :cod"),
    @NamedQuery(name = "Fattura.findByImporto", query = "SELECT f FROM Fattura f WHERE f.importo = :importo"),
    @NamedQuery(name = "Fattura.findByPagato", query = "SELECT f FROM Fattura f WHERE f.pagato = :pagato")})
public class Fattura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod")
    private Integer cod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importo")
    private float importo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagato")
    private int pagato;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Societa cliente;

    public Fattura() {
    }

    public Fattura(Integer cod) {
        this.cod = cod;
    }

    public Fattura(Integer cod, float importo, int pagato) {
        this.cod = cod;
        this.importo = importo;
        this.pagato = pagato;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public int getPagato() {
        return pagato;
    }

    public void setPagato(int pagato) {
        this.pagato = pagato;
    }

    public Societa getCliente() {
        return cliente;
    }

    public void setCliente(Societa cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fattura)) {
            return false;
        }
        Fattura other = (Fattura) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fattura[ cod=" + cod + " ]";
    }
    
}

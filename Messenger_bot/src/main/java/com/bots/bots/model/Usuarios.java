package com.bots.bots.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "usuarios", catalog = "bots", schema = "")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "idpagina")
    private String idpagina;
    @Id
    @Basic(optional = false)
    @Column(name = "iduser")
    private String iduser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Tarjetas> tarjetasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Transacciones> transaccionesList;

    public Usuarios() {
    }

    public Usuarios(String iduser) {
        this.iduser = iduser;
    }

    public Usuarios(String iduser, Date fecha, String idpagina) {
        this.iduser = iduser;
        this.fecha = fecha;
        this.idpagina = idpagina;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdpagina() {
        return idpagina;
    }

    public void setIdpagina(String idpagina) {
        this.idpagina = idpagina;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    @XmlTransient
    public List<Tarjetas> getTarjetasList() {
        return tarjetasList;
    }

    public void setTarjetasList(List<Tarjetas> tarjetasList) {
        this.tarjetasList = tarjetasList;
    }

    @XmlTransient
    public List<Transacciones> getTransaccionesList() {
        return transaccionesList;
    }

    public void setTransaccionesList(List<Transacciones> transaccionesList) {
        this.transaccionesList = transaccionesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuarios[ iduser=" + iduser + " ]";
    }
    
}
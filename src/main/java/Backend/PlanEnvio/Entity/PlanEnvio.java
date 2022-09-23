/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.PlanEnvio.Entity;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import Backend.Envio.Entity.Envio;
import Backend.SitioEntrega.Entity.SitioEntrega;
import Backend.TipoEnvio.Entity.TipoEnvio;
import Backend.TipoProducto.Entity.TipoProducto;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "plan_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanEnvio.findAll", query = "SELECT p FROM PlanEnvio p")})
public class PlanEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "fecha_Registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "fecha_Entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @Column(name = "precio_Envio")
    private int precioEnvio;
    @Basic(optional = false)
    @Column(name = "identificacion_Veh")
    private String identificacionVeh;
    @Basic(optional = false)
    @Column(name = "numero_Guia")
    private int numeroGuia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planEnvio")
    private Collection<Envio> envioCollection;
    @JoinColumn(name = "tipo_Envio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoEnvio tipoEnvio;
    @JoinColumn(name = "tipo_Producto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "sitio_Entrega", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SitioEntrega sitioEntrega;

    public PlanEnvio() {
    }

    public PlanEnvio(Long id) {
        this.id = id;
    }

    public PlanEnvio(Long id, int cantidad, Date fechaRegistro, Date fechaEntrega, int precioEnvio, String identificacionVeh, int numeroGuia) {
        this.id = id;
        this.cantidad = cantidad;
        this.fechaRegistro = fechaRegistro;
        this.fechaEntrega = fechaEntrega;
        this.precioEnvio = precioEnvio;
        this.identificacionVeh = identificacionVeh;
        this.numeroGuia = numeroGuia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(int precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public String getIdentificacionVeh() {
        return identificacionVeh;
    }

    public void setIdentificacionVeh(String identificacionVeh) {
        this.identificacionVeh = identificacionVeh;
    }

    public int getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(int numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    @XmlTransient
    public Collection<Envio> getEnvioCollection() {
        return envioCollection;
    }

    public void setEnvioCollection(Collection<Envio> envioCollection) {
        this.envioCollection = envioCollection;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(TipoEnvio tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public SitioEntrega getSitioEntrega() {
        return sitioEntrega;
    }

    public void setSitioEntrega(SitioEntrega sitioEntrega) {
        this.sitioEntrega = sitioEntrega;
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
        if (!(object instanceof PlanEnvio)) {
            return false;
        }
        PlanEnvio other = (PlanEnvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.PlanEnvio[ id=" + id + " ]";
    }
    
}

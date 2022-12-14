/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.SitioEntrega.Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.TipoEnvio.Entity.TipoEnvio;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "sitio_entrega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SitioEntrega.findAll", query = "SELECT s FROM SitioEntrega s")})
public class SitioEntrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sitioEntrega")
    private Collection<PlanEnvio> planEnvioCollection;
    @JoinColumn(name = "tipo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoEnvio tipo;

    public SitioEntrega() {
    }

    public SitioEntrega(Long id) {
        this.id = id;
    }

    public SitioEntrega(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<PlanEnvio> getPlanEnvioCollection() {
        return planEnvioCollection;
    }

    public void setPlanEnvioCollection(Collection<PlanEnvio> planEnvioCollection) {
        this.planEnvioCollection = planEnvioCollection;
    }

    public TipoEnvio getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnvio tipo) {
        this.tipo = tipo;
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
        if (!(object instanceof SitioEntrega)) {
            return false;
        }
        SitioEntrega other = (SitioEntrega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.SitioEntrega[ id=" + id + " ]";
    }
    
}

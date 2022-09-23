/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.TipoEnvio.Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import Backend.EmpresaEnvio.Entity.EmpresaEnvio;
import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.SitioEntrega.Entity.SitioEntrega;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "tipoenvio")
public class TipoEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEnvio")
    private Collection<PlanEnvio> planEnvioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoEnvioid")
    private Collection<EmpresaEnvio> empresaEnvioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
    private Collection<SitioEntrega> sitioEntregaCollection;

    public TipoEnvio() {
    }

    public TipoEnvio(Long id) {
        this.id = id;
    }

    public TipoEnvio(Long id, String nombre) {
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

    @XmlTransient
    public Collection<EmpresaEnvio> getEmpresaEnvioCollection() {
        return empresaEnvioCollection;
    }

    public void setEmpresaEnvioCollection(Collection<EmpresaEnvio> empresaEnvioCollection) {
        this.empresaEnvioCollection = empresaEnvioCollection;
    }

    @XmlTransient
    public Collection<SitioEntrega> getSitioEntregaCollection() {
        return sitioEntregaCollection;
    }

    public void setSitioEntregaCollection(Collection<SitioEntrega> sitioEntregaCollection) {
        this.sitioEntregaCollection = sitioEntregaCollection;
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
        if (!(object instanceof TipoEnvio)) {
            return false;
        }
        TipoEnvio other = (TipoEnvio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Tipoenvio[ id=" + id + " ]";
    }
    
}

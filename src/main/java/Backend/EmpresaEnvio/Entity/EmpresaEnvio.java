/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.EmpresaEnvio.Entity;

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
import javax.xml.bind.annotation.XmlRootElement;

import Backend.Empresa.Entity.Empresa;
import Backend.TipoEnvio.Entity.TipoEnvio;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "empresa_envio")
public class EmpresaEnvio {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Long id;
	@JoinColumn(name = "empresa_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Empresa empresaId;
	@JoinColumn(name = "tipoenvio_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private TipoEnvio tipoEnvioid;

	public EmpresaEnvio() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Empresa empresaId) {
		this.empresaId = empresaId;
	}

	public TipoEnvio getTipoEnvioid() {
		return tipoEnvioid;
	}

	public void setTipoEnvioid(TipoEnvio tipoEnvioid) {
		this.tipoEnvioid = tipoEnvioid;
	}

}

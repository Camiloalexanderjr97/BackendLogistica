/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.EmpresaEnvio.Model;

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

import Backend.Empresa.model.EmpresaModel;
import Backend.TipoEnvio.Model.TipoEnvioModel;

/**
 *
 * @author USUARIO
 */
public class EmpresaEnvioModel  {

 
    private Long id;
    
    private EmpresaModel empresa;
    
    private TipoEnvioModel tipo;
    
 
    private int empresaId;
  
    private Long tipoEnvioid;

    public EmpresaEnvioModel() {
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public Long getTipoEnvioid() {
        return tipoEnvioid;
    }

    public void setTipoEnvioid(Long tipoEnvioid) {
        this.tipoEnvioid = tipoEnvioid;
    }



	public EmpresaModel getEmpresa() {
		return empresa;
	}



	public void setEmpresa(EmpresaModel empresa) {
		this.empresa = empresa;
	}



	public TipoEnvioModel getTipo() {
		return tipo;
	}



	public void setTipo(TipoEnvioModel tipo) {
		this.tipo = tipo;
	}

   
    
}

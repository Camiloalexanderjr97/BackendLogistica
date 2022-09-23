/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Envio.Model;

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
import Backend.PlanEnvio.Model.PlanEnvioModel;

/**
 *
 * @author USUARIO
 */
public class EnvioModel  {

    private Integer id;
    
    private EmpresaModel empresaModel;
    private PlanEnvioModel planEnvioModel;
    private int empresaId;
    private Long planEnvio;

    public EnvioModel() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(int empresaId) {
        this.empresaId = empresaId;
    }

    public Long getPlanEnvio() {
        return planEnvio;
    }

    public void setPlanEnvio(Long planEnvio) {
        this.planEnvio = planEnvio;
    }


	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}


	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}


	public PlanEnvioModel getPlanEnvioModel() {
		return planEnvioModel;
	}


	public void setPlanEnvioModel(PlanEnvioModel planEnvioModel) {
		this.planEnvioModel = planEnvioModel;
	}
    
    

    
}

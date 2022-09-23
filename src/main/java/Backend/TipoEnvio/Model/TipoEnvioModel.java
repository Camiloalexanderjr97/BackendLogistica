/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.TipoEnvio.Model;


/**
 *
 * @author USUARIO
 */
public class TipoEnvioModel{

  
    private Long id;
    private String nombre;
    private Long planEnvio;
    private Long empresaEnvio;
    private Long sitioEntrega;

    public TipoEnvioModel() {
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


	public Long getPlanEnvio() {
		return planEnvio;
	}


	public void setPlanEnvio(Long planEnvio) {
		this.planEnvio = planEnvio;
	}


	public Long getEmpresaEnvio() {
		return empresaEnvio;
	}


	public void setEmpresaEnvio(Long empresaEnvio) {
		this.empresaEnvio = empresaEnvio;
	}


	public Long getSitioEntrega() {
		return sitioEntrega;
	}


	public void setSitioEntrega(Long sitioEntrega) {
		this.sitioEntrega = sitioEntrega;
	}

   
    
}

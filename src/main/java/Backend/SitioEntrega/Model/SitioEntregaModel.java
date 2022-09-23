/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.SitioEntrega.Model;

/**
 *
 * @author USUARIO
 */
public class SitioEntregaModel	{

    private Long id;
    private String nombre;
    private int planEnvio;
    private int tipo;

    public SitioEntregaModel() {
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

	public int getPlanEnvio() {
		return planEnvio;
	}

	public void setPlanEnvio(int planEnvio) {
		this.planEnvio = planEnvio;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.PlanEnvio.Model;

import java.util.Date;

import Backend.Envio.Model.EnvioModel;
import Backend.SitioEntrega.Model.SitioEntregaModel;
import Backend.TipoEnvio.Model.TipoEnvioModel;
import Backend.TipoProducto.Model.TipoProductoModel;

/**
 *
 * @author USUARIO
 */
public class PlanEnvioModel {

  
    private Long id;
    private int cantidad;
    private Date fechaRegistro;
    private Date fechaEntrega;
    private int precioEnvio;
    private String identificacionVeh;
    private int numeroGuia;
    private EnvioModel envioModel;
    private TipoEnvioModel tipoEnvioModel;
    private TipoProductoModel tipoProductoModel;
    private SitioEntregaModel sitioEntregaModel;
    private long envio;
    private long tipoEnvio;
    private long tipoProducto;
    private long sitioEntrega;

    public PlanEnvioModel() {
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

	public long getEnvio() {
		return envio;
	}

	public void setEnvio(long envio) {
		this.envio = envio;
	}

	public long getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(long tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public long getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(long tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public long getSitioEntrega() {
		return sitioEntrega;
	}

	public void setSitioEntrega(long sitioEntrega) {
		this.sitioEntrega = sitioEntrega;
	}

	public EnvioModel getEnvioModel() {
		return envioModel;
	}

	public void setEnvioModel(EnvioModel envioModel) {
		this.envioModel = envioModel;
	}

	public TipoEnvioModel getTipoEnvioModel() {
		return tipoEnvioModel;
	}

	public void setTipoEnvioModel(TipoEnvioModel tipoEnvioModel) {
		this.tipoEnvioModel = tipoEnvioModel;
	}

	public TipoProductoModel getTipoProductoModel() {
		return tipoProductoModel;
	}

	public void setTipoProductoModel(TipoProductoModel tipoProductoModel) {
		this.tipoProductoModel = tipoProductoModel;
	}

	public SitioEntregaModel getSitioEntregaModel() {
		return sitioEntregaModel;
	}

	public void setSitioEntregaModel(SitioEntregaModel sitioEntregaModel) {
		this.sitioEntregaModel = sitioEntregaModel;
	}
	
	

  
}

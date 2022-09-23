package Backend.PlanEnvio.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.PlanEnvio.Model.PlanEnvioModel;
import Backend.SitioEntrega.Converter.SitioEntregaConverter;
import Backend.TipoEnvio.Converter.TipoEnvioConverter;
import Backend.TipoProducto.Converter.TipoProductoConverter;

@Component("PlanEnvioConverter")
public class PlanEnvioConverter {

	
	@Autowired
	TipoProductoConverter tipoProductoConverter;
	
	@Autowired
	SitioEntregaConverter sitioEntregaConverter;
	
	@Autowired
	TipoEnvioConverter tipoEnvioConverter;
    public PlanEnvioModel entityToModel(PlanEnvio info){
        PlanEnvioModel planEnvioModel = new PlanEnvioModel();
        if(info!= null){
            planEnvioModel.setId(info.getId());
            planEnvioModel.setCantidad(info.getCantidad());
            planEnvioModel.setFechaEntrega(info.getFechaEntrega());
            planEnvioModel.setFechaRegistro(info.getFechaRegistro());
            planEnvioModel.setPrecioEnvio(info.getPrecioEnvio());
            planEnvioModel.setIdentificacionVeh(info.getIdentificacionVeh());
            planEnvioModel.setNumeroGuia(info.getNumeroGuia());
            planEnvioModel.setTipoProductoModel(tipoProductoConverter.entityToModel(info.getTipoProducto()));
            planEnvioModel.setSitioEntregaModel(sitioEntregaConverter.entityToModel(info.getSitioEntrega()));
            planEnvioModel.setTipoEnvioModel(tipoEnvioConverter.entityToModel(info.getTipoEnvio()));
        	}
        return planEnvioModel;
    }


    public PlanEnvio modelToEntity(PlanEnvioModel info){
        PlanEnvio planEnvio = new PlanEnvio();
        if (info != null) {
        	planEnvio.setId(info.getId());
            planEnvio.setCantidad(info.getCantidad());
            planEnvio.setFechaEntrega(info.getFechaEntrega());
            planEnvio.setFechaRegistro(info.getFechaRegistro());
            planEnvio.setPrecioEnvio(info.getPrecioEnvio());
            planEnvio.setIdentificacionVeh(info.getIdentificacionVeh());
            planEnvio.setNumeroGuia(info.getNumeroGuia());
        }
        return planEnvio;
    }
}



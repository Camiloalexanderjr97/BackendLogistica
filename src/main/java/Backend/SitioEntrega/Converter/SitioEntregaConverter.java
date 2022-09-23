package Backend.SitioEntrega.Converter;

import org.springframework.stereotype.Component;

import Backend.SitioEntrega.Entity.SitioEntrega;
import Backend.SitioEntrega.Model.SitioEntregaModel;

@Component("SitioEntregaConverter")
public class SitioEntregaConverter {

    public SitioEntregaModel entityToModel(SitioEntrega info){
        SitioEntregaModel SitioEntregaModel = new SitioEntregaModel();
        if(info!= null){
            SitioEntregaModel.setId(info.getId());
            SitioEntregaModel.setNombre(info.getNombre());
        }
        return SitioEntregaModel;
    }


    public SitioEntrega modelToEntity(SitioEntregaModel info){
        SitioEntrega SitioEntrega = new SitioEntrega();
        if (info != null) {
            SitioEntrega.setId(info.getId());
            SitioEntrega.setNombre(info.getNombre());
        }
        return SitioEntrega;
    }
}



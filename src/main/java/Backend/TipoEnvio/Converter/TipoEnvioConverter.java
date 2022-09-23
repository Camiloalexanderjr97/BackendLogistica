package Backend.TipoEnvio.Converter;

import org.springframework.stereotype.Component;
import Backend.TipoEnvio.Entity.TipoEnvio;
import Backend.TipoEnvio.Model.TipoEnvioModel;

@Component("TipoEnvioConverter")
public class TipoEnvioConverter {

    public TipoEnvioModel entityToModel(TipoEnvio info){
        TipoEnvioModel TipoEnvioModel = new TipoEnvioModel();
        if(info!= null){
            TipoEnvioModel.setId(info.getId());
            TipoEnvioModel.setNombre(info.getNombre());
        }
        return TipoEnvioModel;
    }


    public TipoEnvio modelToEntity(TipoEnvioModel info){
        TipoEnvio TipoEnvio = new TipoEnvio();
        if (info != null) {
            TipoEnvio.setId(info.getId());
            TipoEnvio.setNombre(info.getNombre());
        }
        return TipoEnvio;
    }
}



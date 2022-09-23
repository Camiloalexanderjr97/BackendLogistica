package Backend.TipoEnvio.Service;

import java.util.List;

import Backend.TipoEnvio.Entity.TipoEnvio;
import Backend.TipoEnvio.Model.TipoEnvioModel;



public interface TipoEnvioService {
    
    public abstract List<TipoEnvioModel> listTipoenvio();

    public abstract TipoEnvioModel getTipoenvioByIdModel(Long id);

    public abstract TipoEnvioModel CreateTipoenvio(TipoEnvioModel Tipoenvio);

    public abstract boolean deleteTipoenvio(Long id);

}

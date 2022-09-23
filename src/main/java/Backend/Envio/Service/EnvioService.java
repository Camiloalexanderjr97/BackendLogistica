package Backend.Envio.Service;

import java.util.List;

import Backend.Envio.Entity.Envio;
import Backend.Envio.Model.EnvioModel;



public interface EnvioService {
    
    public abstract List<EnvioModel> listEnvio();

    public abstract Envio getEnvioById(Long id);

    public abstract EnvioModel CreateEnvio(EnvioModel Envio);

    public abstract boolean deleteEnvio(Long id);

}

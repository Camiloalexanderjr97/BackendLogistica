package Backend.SitioEntrega.Service;

import java.util.List;

import Backend.SitioEntrega.Entity.SitioEntrega;
import Backend.SitioEntrega.Model.SitioEntregaModel;
;


public interface SitioEntregaService {
    
    public abstract List<SitioEntregaModel> listSitioEntrega();

    public abstract SitioEntrega getSitioEntregaById(Long id);

    public abstract SitioEntregaModel CreateSitioEntrega(SitioEntregaModel sitioEntrega);

    public abstract boolean deleteSitioEntrega(Long id);

}

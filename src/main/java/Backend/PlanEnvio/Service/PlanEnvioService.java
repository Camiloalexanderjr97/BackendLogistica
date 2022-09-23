package Backend.PlanEnvio.Service;

import java.util.List;

import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.PlanEnvio.Model.PlanEnvioModel;



public interface PlanEnvioService {
    
    public abstract List<PlanEnvioModel> listPlanEnvio();

    public abstract PlanEnvio getPlanEnvioById(Long id);

    public abstract PlanEnvioModel CreatePlanEnvio(PlanEnvioModel PlanEnvio);

    public abstract boolean deletePlanEnvio(Long id);

}

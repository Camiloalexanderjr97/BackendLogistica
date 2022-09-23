package Backend.Envio.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Backend.Empresa.ServicesImpl.EmpresaServiceImpl;
import Backend.Empresa.converter.EmpresaConverter;
import Backend.Envio.Entity.Envio;
import Backend.Envio.Model.EnvioModel;
import Backend.PlanEnvio.Converter.PlanEnvioConverter;

@Component("EnvioConverter")
public class EnvioConverter {
	
	@Autowired
	PlanEnvioConverter planEnvioConverter;
	
	@Autowired
	EmpresaConverter empresaConverter;
	
	@Autowired
	EmpresaServiceImpl empresaServiceImpl;
	

    public EnvioModel entityToModel(Envio info){
        EnvioModel EnvioModel = new EnvioModel();
        if(info!= null){
            EnvioModel.setId(info.getId());
            EnvioModel.setPlanEnvioModel(planEnvioConverter.entityToModel(info.getPlanEnvio()));
            EnvioModel.setEmpresaModel(empresaConverter.entityToModel(empresaServiceImpl.getEmpresaById((long) info.getEmpresaId())));
        }
        return EnvioModel;
    }


    public Envio modelToEntity(EnvioModel info){
        Envio Envio = new Envio();
        if (info != null) {
            Envio.setId(info.getId());
//            Envio.setNombre(info.getNombre());
        }
        return Envio;
    }
}



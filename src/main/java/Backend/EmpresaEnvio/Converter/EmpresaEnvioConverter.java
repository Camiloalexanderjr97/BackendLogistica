package Backend.EmpresaEnvio.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Backend.Empresa.converter.EmpresaConverter;
import Backend.EmpresaEnvio.Entity.EmpresaEnvio;
import Backend.EmpresaEnvio.Model.EmpresaEnvioModel;
import Backend.TipoEnvio.Converter.TipoEnvioConverter;

@Component("EmpresaEnvioConverter")
public class EmpresaEnvioConverter {

	
	@Autowired
	EmpresaConverter empresaConverter;
	@Autowired
	TipoEnvioConverter tipoEnvioConverter;
	
    public EmpresaEnvioModel entityToModel(EmpresaEnvio info){
        EmpresaEnvioModel empresaEnvioModel = new EmpresaEnvioModel();
        if(info!= null){
            empresaEnvioModel.setEmpresa(empresaConverter.entityToModel(info.getEmpresaId()));
            empresaEnvioModel.setTipo(tipoEnvioConverter.entityToModel(info.getTipoEnvioid()));
        }
        return empresaEnvioModel;
    }


    public EmpresaEnvio modelToEntity(EmpresaEnvioModel infoModel){
        EmpresaEnvio empresaEnvio = new EmpresaEnvio();
        if (infoModel != null) {

        	empresaEnvio.setEmpresaId(empresaConverter.modelToEntity(infoModel.getEmpresa()));
        	empresaEnvio.setTipoEnvioid(tipoEnvioConverter.modelToEntity(infoModel.getTipo()));
        }
        return empresaEnvio;
    }
}



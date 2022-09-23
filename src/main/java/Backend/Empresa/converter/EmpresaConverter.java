package Backend.Empresa.converter;

import org.springframework.stereotype.Component;

import Backend.Empresa.Entity.Empresa;
import Backend.Empresa.model.EmpresaModel;

@Component("EmpresaConverter")
public class EmpresaConverter {

    public EmpresaModel entityToModel(Empresa info){
        EmpresaModel EmpresaModel = new EmpresaModel();
        if(info!= null){
            EmpresaModel.setId(info.getId());
            EmpresaModel.setNombre(info.getNombre());
        }
        return EmpresaModel;
    }


    public Empresa modelToEntity(EmpresaModel info){
        Empresa Empresa = new Empresa();
        if (info != null) {
            Empresa.setId(info.getId());
            Empresa.setNombre(info.getNombre());
        }
        return Empresa;
    }
}



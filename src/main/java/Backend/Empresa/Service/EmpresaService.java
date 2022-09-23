package Backend.Empresa.Service;

import java.util.List;

import Backend.Empresa.Entity.Empresa;
import Backend.Empresa.model.EmpresaModel;


public interface EmpresaService {
    
    public abstract List<EmpresaModel> listEmpresa();

    public abstract Empresa getEmpresaById(Long id);

    public abstract EmpresaModel CreateEmpresa(EmpresaModel Empresa);

    public abstract boolean deleteEmpresa(Long id);

}

package Backend.EmpresaEnvio.Service;

import java.util.List;

import Backend.EmpresaEnvio.Model.EmpresaEnvioModel;


public interface EmpresaEnvioService {
    
    public abstract List<EmpresaEnvioModel> listEmpresaEnvio();

    public abstract EmpresaEnvioModel getEmpresaEnvioById(Long id);

    public abstract EmpresaEnvioModel CreateEmpresaEnvio(EmpresaEnvioModel Empresa);

    public abstract boolean deleteEmpresaEnvio(Long id);

}

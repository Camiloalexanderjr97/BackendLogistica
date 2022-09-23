package Backend.EmpresaEnvio.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.Empresa.ServicesImpl.EmpresaServiceImpl;
import Backend.EmpresaEnvio.Converter.EmpresaEnvioConverter;
import Backend.EmpresaEnvio.Entity.EmpresaEnvio;
import Backend.EmpresaEnvio.Model.EmpresaEnvioModel;
import Backend.EmpresaEnvio.Repository.EmpresaEnvioRepository;
import Backend.EmpresaEnvio.Service.EmpresaEnvioService;
import Backend.EmpresaEnvio.Entity.EmpresaEnvio;
import Backend.EmpresaEnvio.Model.EmpresaEnvioModel;
import Backend.TipoEnvio.Converter.TipoEnvioConverter;
import Backend.TipoEnvio.ServiceImpl.TipoenvioServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("empresaEnvioServiceImpl")
public class EmpresaEnvioServiceImpl implements EmpresaEnvioService {

	@Autowired
	EmpresaEnvioRepository empresaEnvioRepositories;
	
	@Autowired
	EmpresaEnvioConverter empresaEnvioConverter;
	@Autowired
	EmpresaServiceImpl empresaServiceImpl;
	@Autowired
	TipoenvioServiceImpl tipoenvioServiceImpl;
	@Autowired
	TipoEnvioConverter tipoEnvioConverter;
	

	
	

	public Boolean updateEmpresaEnvio(EmpresaEnvioModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (EmpresaEnvioRepositories.updateEmpresaEnvioSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public List<EmpresaEnvioModel> listEmpresaEnvio() {
	
			List<EmpresaEnvio> listado = (List<EmpresaEnvio>) empresaEnvioRepositories.findAll();
			List<EmpresaEnvioModel> model = new ArrayList<EmpresaEnvioModel>();

			for(EmpresaEnvio list : listado) {
				model.add(empresaEnvioConverter.entityToModel(list));
			}
			return model;
		
		
		
	}

	@Override
	public EmpresaEnvioModel getEmpresaEnvioById(Long id) {
		return  empresaEnvioConverter.entityToModel(empresaEnvioRepositories.findById(id).get());
		}


	@Override
	public EmpresaEnvioModel CreateEmpresaEnvio(EmpresaEnvioModel empresa) {
		EmpresaEnvio empEnv = new EmpresaEnvio();
		Long id =(long) empresa.getEmpresaId();
		empEnv.setEmpresaId(empresaServiceImpl.getEmpresaById(id));
		empEnv.setTipoEnvioid(tipoEnvioConverter.modelToEntity(tipoenvioServiceImpl.getTipoenvioByIdModel(empresa.getTipoEnvioid())));
		
		return empresaEnvioConverter.entityToModel(empresaEnvioRepositories.save(empEnv));
	}

	@Override
	public boolean deleteEmpresaEnvio(Long id) {
		boolean isDelete = false;
		try {
			empresaEnvioRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}



}

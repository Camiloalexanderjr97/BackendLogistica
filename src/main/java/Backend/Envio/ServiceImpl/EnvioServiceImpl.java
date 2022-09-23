package Backend.Envio.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Backend.EmpresaEnvio.ServiceImpl.EmpresaEnvioServiceImpl;
import Backend.Envio.Converter.EnvioConverter;
import Backend.Envio.Entity.Envio;
import Backend.Envio.Model.EnvioModel;
import Backend.Envio.Repository.EnvioRepository;
import Backend.Envio.Service.EnvioService;
import Backend.PlanEnvio.ServiceImpl.PlanEnvioServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Service("envioServiceImpl")
public class EnvioServiceImpl implements EnvioService{

	@Autowired
	EnvioRepository envioRepositories;

	@Autowired
	@Qualifier("empresaEnvioServiceImpl")
	EmpresaEnvioServiceImpl empresaEnvioServiceImpl;

	@Autowired
	@Qualifier("planEnvioServiceImpl")
	PlanEnvioServiceImpl planEnvioServiceImpl;
	
	@Autowired
	EnvioConverter envioConverter;
	
	@Override
	public List<EnvioModel> listEnvio() {
		
			List<Envio> lista =(List<Envio>) envioRepositories.findAll();
			List<EnvioModel> model = new ArrayList<EnvioModel>();
			
			for(Envio aux: lista) {
				model.add(envioConverter.entityToModel(aux));
			}
		return model;
	}


	@Override
	public Envio getEnvioById(Long id) {
		return envioRepositories.findById(id).get();
	}

	@Override
	public boolean deleteEnvio(Long id) {
		boolean isDelete = false;
		try {
			envioRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updateEnvio(EnvioModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (EnvioRepositories.updateEnvioSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public EnvioModel CreateEnvio(EnvioModel envio) {
		
		Envio env = new Envio();
		
		env.setEmpresaId(envio.getEmpresaId());
		env.setPlanEnvio(planEnvioServiceImpl.getPlanEnvioById(envio.getPlanEnvio()));
		
		return envioConverter.entityToModel(envioRepositories.save(env));
	}

		
}

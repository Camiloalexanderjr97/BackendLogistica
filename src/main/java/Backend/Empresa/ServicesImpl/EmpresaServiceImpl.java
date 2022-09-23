package Backend.Empresa.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.Empresa.Entity.Empresa;
import Backend.Empresa.Repositories.EmpresaRepository;
import Backend.Empresa.Service.EmpresaService;
import Backend.Empresa.converter.EmpresaConverter;
import Backend.Empresa.model.EmpresaModel;

import java.util.ArrayList;
import java.util.List;


@Service("empresaServiceImpl")
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	EmpresaRepository empresaRepositories;
	@Autowired
	EmpresaConverter empresaConverter;

	@Override
	public List<EmpresaModel> listEmpresa() {
		List<Empresa> listado = (List<Empresa>) empresaRepositories.findAll();
		List<EmpresaModel> model = new ArrayList<EmpresaModel>();

		for(Empresa list : listado) {
			model.add(empresaConverter.entityToModel(list));
		}
		
		return model;
	}


	@Override
	public Empresa getEmpresaById(Long id) {
		return empresaRepositories.findById(id).get();
	}

	@Override
	public boolean deleteEmpresa(Long id) {
		boolean isDelete = false;
		try {
			empresaRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updateEmpresa(EmpresaModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (EmpresaRepositories.updateEmpresaSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public EmpresaModel CreateEmpresa(EmpresaModel Empresa) {
		return empresaConverter.entityToModel(empresaRepositories.save(empresaConverter.modelToEntity(Empresa)));
	}

		
}

package Backend.SitioEntrega.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SitioEntrega.Entity.SitioEntrega;
import Backend.SitioEntrega.Model.SitioEntregaModel;
import Backend.SitioEntrega.Repository.SitioEntregaRepository;
import Backend.SitioEntrega.Service.SitioEntregaService;
import Backend.SitioEntrega.Converter.SitioEntregaConverter;
import java.util.ArrayList;
import java.util.List;


@Service("sitioEntregaServiceImpl")
public class SitioEntregaServiceImpl implements SitioEntregaService{

	@Autowired
	SitioEntregaRepository SitioEntregaRepositories;
	@Autowired
	SitioEntregaConverter SitioEntregaConverter;

	@Override
	public List<SitioEntregaModel> listSitioEntrega() {
		List<SitioEntrega> listado = (List<SitioEntrega>) SitioEntregaRepositories.findAll();
		List<SitioEntregaModel> model = new ArrayList<SitioEntregaModel>();

		for(SitioEntrega list : listado) {
			model.add(SitioEntregaConverter.entityToModel(list));
		}
		
		return model;
	}


	@Override
	public SitioEntrega getSitioEntregaById(Long id) {
		return SitioEntregaRepositories.findById(id).get();
	}

	@Override
	public boolean deleteSitioEntrega(Long id) {
		boolean isDelete = false;
		try {
			SitioEntregaRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updateSitioEntrega(SitioEntregaModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (SitioEntregaRepositories.updateSitioEntregaSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public SitioEntregaModel CreateSitioEntrega(SitioEntregaModel SitioEntrega) {
		return SitioEntregaConverter.entityToModel(SitioEntregaRepositories.save(SitioEntregaConverter.modelToEntity(SitioEntrega)));
	}

		
}

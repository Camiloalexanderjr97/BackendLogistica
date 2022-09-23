package Backend.PlanEnvio.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.PlanEnvio.Converter.PlanEnvioConverter;
import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.PlanEnvio.Model.PlanEnvioModel;
import Backend.PlanEnvio.Repository.PlanEnvioRepository;
import Backend.PlanEnvio.Service.PlanEnvioService;
import Backend.SitioEntrega.ServiceImpl.SitioEntregaServiceImpl;
import Backend.TipoEnvio.Converter.TipoEnvioConverter;
import Backend.TipoEnvio.ServiceImpl.TipoenvioServiceImpl;
import Backend.TipoProducto.Converter.TipoProductoConverter;
import Backend.TipoProducto.ServiceImpl.TipoProductoServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Service("planEnvioServiceImpl")
public class PlanEnvioServiceImpl implements PlanEnvioService{

	@Autowired
	PlanEnvioRepository planEnvioRepositories;
	@Autowired
	PlanEnvioConverter planEnvioConverter;
	@Autowired
	TipoenvioServiceImpl tipoenvioServiceImpl;
	@Autowired
	TipoProductoServiceImpl tipoProductoServiceImpl;
	@Autowired
	SitioEntregaServiceImpl sitioEntregaServiceImpl;
	@Autowired
	TipoProductoConverter tipoProductoConverter;
	@Autowired
	TipoEnvioConverter tipoEnvioConverter;
	
	@Override
	public List<PlanEnvioModel> listPlanEnvio() {
		List<PlanEnvio> listado = (List<PlanEnvio>) planEnvioRepositories.findAll();
		List<PlanEnvioModel> model = new ArrayList<PlanEnvioModel>();

		for(PlanEnvio list : listado) {
			model.add(planEnvioConverter.entityToModel(list));
		}
		
		return model;
	}


	@Override
	public PlanEnvio getPlanEnvioById(Long id) {
		return planEnvioRepositories.findById(id).get();
	}

	@Override
	public boolean deletePlanEnvio(Long id) {
		boolean isDelete = false;
		try {
			planEnvioRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updatePlanEnvio(PlanEnvioModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (PlanEnvioRepositories.updatePlanEnvioSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public PlanEnvioModel CreatePlanEnvio(PlanEnvioModel planEnvio) {
		PlanEnvio p = new PlanEnvio();
		p = planEnvioConverter.modelToEntity(planEnvio);
		
		p.setTipoEnvio(tipoEnvioConverter.modelToEntity(tipoenvioServiceImpl.getTipoenvioByIdModel(planEnvio.getTipoEnvio())));
		
		p.setTipoProducto(tipoProductoConverter.modelToEntity(tipoProductoServiceImpl.getTipoProductoById(planEnvio.getTipoProducto())));
		
		p.setSitioEntrega(sitioEntregaServiceImpl.getSitioEntregaById(planEnvio.getSitioEntrega()));
		
		return planEnvioConverter.entityToModel(planEnvioRepositories.save(p));
	}

		
}

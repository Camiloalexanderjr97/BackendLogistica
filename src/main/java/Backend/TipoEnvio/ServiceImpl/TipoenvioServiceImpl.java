package Backend.TipoEnvio.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.TipoEnvio.Converter.TipoEnvioConverter;
import Backend.TipoEnvio.Entity.TipoEnvio;
import Backend.TipoEnvio.Model.TipoEnvioModel;
import Backend.TipoEnvio.Repository.TipoEnvioRepository;
import Backend.TipoEnvio.Service.TipoEnvioService;

import java.util.ArrayList;
import java.util.List;


@Service("TipoenvioServiceImpl")
public class TipoenvioServiceImpl implements TipoEnvioService{

	@Autowired
	TipoEnvioRepository tipoenvioRepositories;
	@Autowired
	TipoEnvioConverter tipoenvioConverter;

	@Override
	public List<TipoEnvioModel> listTipoenvio() {
		List<TipoEnvio> listado = (List<TipoEnvio>) tipoenvioRepositories.findAll();
		List<TipoEnvioModel> model = new ArrayList<TipoEnvioModel>();

		for(TipoEnvio list : listado) {
			model.add(tipoenvioConverter.entityToModel(list));
		}
		
		return model;
	}


	@Override
	public TipoEnvioModel getTipoenvioByIdModel(Long id) {
		return tipoenvioConverter.entityToModel(tipoenvioRepositories.findById(id).get());
	}

	@Override
	public boolean deleteTipoenvio(Long id) {
		boolean isDelete = false;
		try {
			tipoenvioRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updateTipoenvio(TipoEnvioModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (TipoenvioRepositories.updateTipoenvioSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public TipoEnvioModel CreateTipoenvio(TipoEnvioModel Tipoenvio) {
		return tipoenvioConverter.entityToModel(tipoenvioRepositories.save(tipoenvioConverter.modelToEntity(Tipoenvio)));
	}

		
}

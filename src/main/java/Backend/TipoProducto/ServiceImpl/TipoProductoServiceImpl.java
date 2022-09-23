package Backend.TipoProducto.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.TipoProducto.Converter.TipoProductoConverter;
import Backend.TipoProducto.Entity.TipoProducto;
import Backend.TipoProducto.Model.TipoProductoModel;
import Backend.TipoProducto.Repository.TipoProductoRepository;
import Backend.TipoProducto.Service.TipoProductoService;

import java.util.ArrayList;
import java.util.List;


@Service("tipoProductoServiceImpl")
public class TipoProductoServiceImpl implements TipoProductoService{

	@Autowired
	TipoProductoRepository tipoProductoRepositories;
	@Autowired
	TipoProductoConverter tipoProductoConverter;

	@Override
	public List<TipoProductoModel> listTipoProducto() {
		List<TipoProducto> listado = (List<TipoProducto>) tipoProductoRepositories.findAll();
		List<TipoProductoModel> model = new ArrayList<TipoProductoModel>();

		for(TipoProducto list : listado) {
			model.add(tipoProductoConverter.entityToModel(list));
		}
		
		return model;
	}


	@Override
	public TipoProductoModel getTipoProductoById(Long id) {
		return tipoProductoConverter.entityToModel(tipoProductoRepositories.findById(id).get());
	}

	@Override
	public boolean deleteTipoProducto(Long id) {
		boolean isDelete = false;
		try {
			tipoProductoRepositories.deleteById(id);
			isDelete = true;
		} catch (Exception e) {

		}
		return isDelete;
	}


	public Boolean updateTipoProducto(TipoProductoModel info) {

		Boolean resultado = false;
		try {
			System.out.print(".............---------------------------" + info.toString());

//			if (TipoProductoRepositories.updateTipoProductoSetStatusForNameNative(info.getId(),
//					info.getNombre()) != 0) {
//				resultado = true;
//			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return resultado;
	}

	@Override
	public TipoProductoModel CreateTipoProducto(TipoProductoModel TipoProducto) {
		return tipoProductoConverter.entityToModel(tipoProductoRepositories.save(tipoProductoConverter.modelToEntity(TipoProducto)));
	}

		
}

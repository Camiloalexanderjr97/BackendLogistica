package Backend.TipoProducto.Converter;

import org.springframework.stereotype.Component;

import Backend.TipoProducto.Entity.TipoProducto;
import Backend.TipoProducto.Model.TipoProductoModel;

@Component("TipoProductoConverter")
public class TipoProductoConverter {

    public TipoProductoModel entityToModel(TipoProducto info){
        TipoProductoModel TipoProductoModel = new TipoProductoModel();
        if(info!= null){
            TipoProductoModel.setId(info.getId());
            TipoProductoModel.setNombre(info.getNombre());
        }
        return TipoProductoModel;
    }


    public TipoProducto modelToEntity(TipoProductoModel info){
        TipoProducto TipoProducto = new TipoProducto();
        if (info != null) {
            TipoProducto.setId(info.getId());
            TipoProducto.setNombre(info.getNombre());
        }
        return TipoProducto;
    }
}



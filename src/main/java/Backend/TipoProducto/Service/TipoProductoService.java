package Backend.TipoProducto.Service;

import java.util.List;

import Backend.TipoProducto.Entity.TipoProducto;
import Backend.TipoProducto.Model.TipoProductoModel;


public interface TipoProductoService {
    
    public abstract List<TipoProductoModel> listTipoProducto();

    public abstract TipoProductoModel getTipoProductoById(Long id);

    public abstract TipoProductoModel CreateTipoProducto(TipoProductoModel tipoProducto);

    public abstract boolean deleteTipoProducto(Long id);

}

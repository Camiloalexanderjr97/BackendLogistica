package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.TipoProducto.Model.TipoProductoModel;
import Backend.TipoProducto.Service.TipoProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/TipoProducto")
public class TipoProductoController {

	@Autowired
	TipoProductoService tipoProducto;

	@GetMapping("/tipoProductoList")
	public ResponseEntity<List<TipoProductoModel>> listado() {

		try {

			return new ResponseEntity<>(tipoProducto.listTipoProducto(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarTipoProducto")
	public ResponseEntity<TipoProductoModel> crearTipoProducto(@RequestBody TipoProductoModel info) {
		try {

			return new ResponseEntity<>(tipoProducto.CreateTipoProducto(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTipoProducto/{id}")
	public ResponseEntity<TipoProductoModel> getTipoProducto(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(tipoProducto.getTipoProductoById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(tipoProducto.deleteTipoProducto(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateTipoProducto(@RequestBody TipoProductoModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return TipoProductoServices.updateTipoProducto(info, id);
//	}

}

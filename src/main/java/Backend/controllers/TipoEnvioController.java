package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.TipoEnvio.Entity.TipoEnvio;
import Backend.TipoEnvio.Service.TipoEnvioService;
import Backend.TipoEnvio.Converter.*;
import Backend.TipoEnvio.Model.*;

import java.util.List;

@RestController
@RequestMapping("/api/TipoEnvio")
public class TipoEnvioController {

	@Autowired
	TipoEnvioService tipoEnvioService;


	@GetMapping("/listTipoEnvio")
	public ResponseEntity<List<TipoEnvioModel>> listado() {

		try {

			return new ResponseEntity<>(tipoEnvioService.listTipoenvio(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarTipoEnvio")
	public ResponseEntity<TipoEnvioModel> crearTipoEnvio(@RequestBody TipoEnvioModel info) {
		try {

			return new ResponseEntity<>(tipoEnvioService.CreateTipoenvio(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTipoEnvio/{id}")
	public ResponseEntity<TipoEnvioModel> getTipoEnvio(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(tipoEnvioService.getTipoenvioByIdModel(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(tipoEnvioService.deleteTipoenvio(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateTipoEnvio(@RequestBody TipoEnvioModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return TipoEnvioServices.updateTipoEnvio(info, id);
//	}

}

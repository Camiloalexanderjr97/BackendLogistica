package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.SitioEntrega.Converter.SitioEntregaConverter;
import Backend.SitioEntrega.Entity.SitioEntrega;
import Backend.SitioEntrega.Model.SitioEntregaModel;
import Backend.SitioEntrega.Service.SitioEntregaService;

import java.util.List;

@RestController
@RequestMapping("/api/SitioEntrega")
public class SitioEntregaController {

	@Autowired
	SitioEntregaService sitioEntregaService;

	@Autowired
	SitioEntregaConverter sitioEntregaConverter;

	@GetMapping("/listSitioEntrega")
	public ResponseEntity<List<SitioEntregaModel>> listado() {

		try {

			return new ResponseEntity<>(sitioEntregaService.listSitioEntrega(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarSitioEntrega")
	public ResponseEntity<SitioEntregaModel> crearSitioEntrega(@RequestBody SitioEntregaModel info) {
		try {

			return new ResponseEntity<>(sitioEntregaService.CreateSitioEntrega(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getSitioEntrega/{id}")
	public ResponseEntity<SitioEntrega> getSitioEntrega(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(sitioEntregaService.getSitioEntregaById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(sitioEntregaService.deleteSitioEntrega(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateSitioEntrega(@RequestBody SitioEntregaModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return SitioEntregaServices.updateSitioEntrega(info, id);
//	}

}

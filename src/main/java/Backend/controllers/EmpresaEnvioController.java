package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.EmpresaEnvio.Converter.EmpresaEnvioConverter;
import Backend.EmpresaEnvio.Entity.EmpresaEnvio;
import Backend.EmpresaEnvio.Model.EmpresaEnvioModel;
import Backend.EmpresaEnvio.Service.EmpresaEnvioService;

import java.util.List;

@RestController
@RequestMapping("/api/EmpresaEnvio")
public class EmpresaEnvioController {

	@Autowired
	EmpresaEnvioService empresaEnvioService;

	@Autowired
	EmpresaEnvioConverter empresaEnvioConverter;

	@GetMapping("/listEmpresaEnvio")
	public ResponseEntity<List<EmpresaEnvioModel>> listado() {

		try {

			return new ResponseEntity<>(empresaEnvioService.listEmpresaEnvio(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarEmpresaEnvio")
	public ResponseEntity<EmpresaEnvioModel> crearEmpresaEnvio(@RequestBody EmpresaEnvioModel info) {
		try {

			return new ResponseEntity<>(empresaEnvioService.CreateEmpresaEnvio(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEmpresaEnvio/{id}")
	public ResponseEntity<EmpresaEnvioModel> getEmpresaEnvio(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(empresaEnvioService.getEmpresaEnvioById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(empresaEnvioService.deleteEmpresaEnvio(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateEmpresaEnvio(@RequestBody EmpresaEnvioModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return EmpresaEnvioServices.updateEmpresaEnvio(info, id);
//	}

}

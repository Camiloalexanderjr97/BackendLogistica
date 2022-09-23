package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.Empresa.Entity.Empresa;
import Backend.Empresa.Service.EmpresaService;
import Backend.Empresa.converter.EmpresaConverter;
import Backend.Empresa.model.EmpresaModel;

import java.util.List;

@RestController
@RequestMapping("/api/Empresa")
public class EmpresaController {

	@Autowired
	EmpresaService empresaService;

	@Autowired
	EmpresaConverter empresaConverter;

	@GetMapping("/listEmpresa")
	public ResponseEntity<List<EmpresaModel>> listado() {

		try {

			return new ResponseEntity<>(empresaService.listEmpresa(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarEmpresa")
	public ResponseEntity<EmpresaModel> crearEmpresa(@RequestBody EmpresaModel info) {
		try {

			return new ResponseEntity<>(empresaService.CreateEmpresa(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEmpresa/{id}")
	public ResponseEntity<Empresa> getEmpresa(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(empresaService.getEmpresaById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(empresaService.deleteEmpresa(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateEmpresa(@RequestBody EmpresaModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return EmpresaServices.updateEmpresa(info, id);
//	}

}

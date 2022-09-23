package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.PlanEnvio.Entity.PlanEnvio;
import Backend.PlanEnvio.Model.PlanEnvioModel;
import Backend.PlanEnvio.Service.PlanEnvioService;

import java.util.List;

@RestController
@RequestMapping("/api/PlanEnvio")
public class PlanEnvioController {

	@Autowired
	PlanEnvioService planEnvioService;

	@GetMapping("/planEnviosList")
	public ResponseEntity<List<PlanEnvioModel>> listado() {

		try {

			return new ResponseEntity<>(planEnvioService.listPlanEnvio(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarPlanEnvio")
	public ResponseEntity<PlanEnvioModel> crearPlanEnvio(@RequestBody PlanEnvioModel info) {
		try {

			return new ResponseEntity<>(planEnvioService.CreatePlanEnvio(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getPlanEnvio/{id}")
	public ResponseEntity<PlanEnvio> getPlanEnvio(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(planEnvioService.getPlanEnvioById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(planEnvioService.deletePlanEnvio(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updatePlanEnvio(@RequestBody PlanEnvioModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return PlanEnvioServices.updatePlanEnvio(info, id);
//	}

}

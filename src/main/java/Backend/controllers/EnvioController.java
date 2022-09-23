package Backend.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Backend.Envio.Entity.Envio;
import Backend.Envio.Model.EnvioModel;
import Backend.Envio.Service.EnvioService;

import java.util.List;

@RestController
@RequestMapping("/api/Envio")
public class EnvioController {

	@Autowired
	EnvioService EnvioService;

	@GetMapping("/EnviosList")
	public ResponseEntity<List<EnvioModel>> listado() {

		try {

			return new ResponseEntity<>(EnvioService.listEnvio(), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/GuardarEnvio")
	public ResponseEntity<EnvioModel> crearEnvio(@RequestBody EnvioModel info) {
		try {

			return new ResponseEntity<>(EnvioService.CreateEnvio(info), HttpStatus.CREATED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getEnvio/{id}")
	public ResponseEntity<Envio> getEnvio(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(EnvioService.getEnvioById(id), HttpStatus.OK);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(EnvioService.deleteEnvio(id), HttpStatus.ACCEPTED);
		} catch (HibernateException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	@PostMapping("/update/{id}")
//	public Boolean updateEnvio(@RequestBody EnvioModel info) {
//
//		System.out.println(info.toString());
//		Long id = Long.parseLong(info.getId() + "");
//		return EnvioServices.updateEnvio(info, id);
//	}

}

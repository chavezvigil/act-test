package sv.com.telefonica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.com.telefonica.model.entity.ActClienteEntity;
import sv.com.telefonica.model.repository.ActClienteRepository;

@RestController
public class AppWsController {

	@Autowired
	private ActClienteRepository clientesRepo;
	
	@GetMapping("/clientes")
	public List<ActClienteEntity> listClientes(HttpServletRequest request) {

		List<ActClienteEntity> listClientes = clientesRepo.findAll();
		return listClientes;
	}
}

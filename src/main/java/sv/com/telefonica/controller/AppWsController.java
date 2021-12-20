package sv.com.telefonica.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.com.telefonica.model.dto.ActCustomClienteDto;
import sv.com.telefonica.model.entity.ActClienteEntity;
import sv.com.telefonica.model.repository.ActClienteRepository;
import sv.com.telefonica.model.service.adapter.ActClientesAdapter;

@RestController
public class AppWsController {

	@Autowired
	private ActClienteRepository clientesRepo;

	@GetMapping("/clientes")
	public List<ActCustomClienteDto> listClientes(HttpServletRequest request) throws ParseException {

		ActClientesAdapter adapter = new ActClientesAdapter();
		List<ActCustomClienteDto> lista = new ArrayList<ActCustomClienteDto>();
		List<ActClienteEntity> listClientes = clientesRepo.findAll();
		for (ActClienteEntity customer : listClientes) {
			ActCustomClienteDto dto = adapter.transformEntityToDto(customer);
			lista.add(dto);
		}

		return lista;

	}
}

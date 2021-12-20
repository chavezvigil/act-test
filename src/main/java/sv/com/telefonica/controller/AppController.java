package sv.com.telefonica.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sv.com.telefonica.model.entity.ActClienteEntity;
import sv.com.telefonica.model.entity.ActTipoPersonaEntity;
import sv.com.telefonica.model.entity.ActUsuarioEntity;
import sv.com.telefonica.model.repository.ActClienteRepository;
import sv.com.telefonica.model.repository.ActTipoPersonaRepository;
import sv.com.telefonica.model.repository.ActUsuarioRepository;

@Controller
public class AppController {

	@Autowired
	private ActUsuarioRepository userRepo;

	@Autowired
	private ActClienteRepository clientesRepo;
	
	@Autowired
	private ActTipoPersonaRepository tpeRepo;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/user_registro")
	public String showRegistrationForm(Model model) {

		model.addAttribute("user", new ActUsuarioEntity());
		return "user_registro_form";
	}

	@PostMapping("/user_proceso_registro")
	public String processRegister(ActUsuarioEntity user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);

		return "user_registro_exito";
	}

	@GetMapping("/clientes_consulta")
	public String listClientes(Model model) {

		List<ActClienteEntity> listUsers = clientesRepo.findAll();
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();
		
		model.addAttribute("cliente", new ActClienteEntity());
		model.addAttribute("listClientes", listUsers);
		model.addAttribute("listTpe", listTpe);

		return "cliente_lista";
	}
	
	@PostMapping("/cliente_proceso_registro")
	public String processRegisterClient(Model model, Principal principal, ActClienteEntity cliente) {
		

		cliente.setFechaCreado(new Date());
		cliente.setCreadoPor(principal.getName().split("@")[0]);
		
		clientesRepo.save(cliente);
		
		List<ActClienteEntity> listUsers = clientesRepo.findAll();
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();
		
		model.addAttribute("cliente", new ActClienteEntity());
		model.addAttribute("listClientes", listUsers);
		model.addAttribute("listTpe", listTpe);

		return "cliente_lista";
	}

}

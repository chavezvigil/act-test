package sv.com.telefonica.controller;

import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sv.com.telefonica.framework.utils.ClienteExcelExporter;
import sv.com.telefonica.model.entity.ActClienteEntity;
import sv.com.telefonica.model.entity.ActDirClienteEntity;
import sv.com.telefonica.model.entity.ActTipoPersonaEntity;
import sv.com.telefonica.model.entity.ActUsuarioEntity;
import sv.com.telefonica.model.repository.ActClienteRepository;
import sv.com.telefonica.model.repository.ActDirClienteRepository;
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

	@Autowired
	private ActDirClienteRepository dirRepo;

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

	@GetMapping("/cliente_eliminar")
	public String deleteClient(Model model, Principal principal, @RequestParam Integer customerId) {

		if (customerId != null) {
			List<ActClienteEntity> clientes = clientesRepo.findById(customerId);
			clientesRepo.delete(clientes.get(0));
		}

		List<ActClienteEntity> listUsers = clientesRepo.findAll();
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();

		model.addAttribute("cliente", new ActClienteEntity());
		model.addAttribute("listClientes", listUsers);
		model.addAttribute("listTpe", listTpe);

		return "cliente_lista";
	}

	@GetMapping("/cliente_export_excel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=clientes_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<ActClienteEntity> listClientes = clientesRepo.findAll();
		ClienteExcelExporter excelExporter = new ClienteExcelExporter(listClientes);

		excelExporter.export(response);
	}

	@GetMapping("/cliente_editar")
	public String editarClient(Model model, Principal principal, @RequestParam Integer customerId) {

		if (customerId != null) {
			List<ActClienteEntity> clientes = clientesRepo.findById(customerId);
			model.addAttribute("cliente", clientes.get(0));

			
			//Direccion
			ActDirClienteEntity dir = new ActDirClienteEntity();
			dir.setActClienteEntity(clientes.get(0));
			model.addAttribute("address", dir);
			
			//Documentos
		}

		
		//Listas
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();
		model.addAttribute("listTpe", listTpe);

		List<ActDirClienteEntity> listDir = dirRepo.findByIdCliente(customerId);
		model.addAttribute("listDir", listDir);

		return "cliente_editar";
	}

	@PostMapping("/cliente_proceo_editar")
	public String editarProcesoClient(Model model, Principal principal, ActClienteEntity cliente) {

		if (cliente != null) {
			cliente.setFechaModificado(new Date());
			cliente.setFechaCreado(new Date());
			cliente.setModificadoPor(principal.getName().split("@")[0]);

			clientesRepo.save(cliente);
			model.addAttribute("cliente", cliente);

			//Direccion
			ActDirClienteEntity dir = new ActDirClienteEntity();
			dir.setActClienteEntity(cliente);
			model.addAttribute("address", dir);
			
			//Documentos

		}

		
		//Listas
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();
		model.addAttribute("listTpe", listTpe);

		List<ActDirClienteEntity> listDir = dirRepo.findByIdCliente(cliente.getId());
		model.addAttribute("listDir", listDir);

		return "cliente_editar";
	}

	@PostMapping("/direccion_proceso_registro")
	public String addDireccion(Model model, Principal principal, ActDirClienteEntity dir) {

		if (dir.getActClienteEntity().getId() != null) {
			dir.setFechaCreado(new Date());
			dir.setCreadoPor(principal.getName().split("@")[0]);
			dirRepo.save(dir);
			
			//Direccion
			List<ActClienteEntity> clientes = clientesRepo.findById(dir.getActClienteEntity().getId());
			model.addAttribute("cliente", clientes.get(0));
			model.addAttribute("address", dir);
			
			//Documento
		}

		
		//Listas
		List<ActTipoPersonaEntity> listTpe = tpeRepo.findAll();
		model.addAttribute("listTpe", listTpe);

		List<ActDirClienteEntity> listDir = dirRepo.findByIdCliente(dir.getActClienteEntity().getId());
		model.addAttribute("listDir", listDir);

		return "cliente_editar";
	}

}

package sv.com.telefonica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sv.com.telefonica.model.entity.ActUsuarioEntity;
import sv.com.telefonica.model.repository.ActUsuarioRepository;

@Controller
public class AppController {

	@Autowired
	private ActUsuarioRepository userRepo;

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

	@GetMapping("/usuarios")
	public String listUsers(Model model) {

		List<ActUsuarioEntity> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "users";
	}

	

}

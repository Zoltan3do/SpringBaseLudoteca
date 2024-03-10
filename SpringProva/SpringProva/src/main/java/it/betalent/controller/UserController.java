package it.betalent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.betalent.entity.User;
import it.betalent.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/autentica")
	public String autentica(@RequestParam("username")String username,@RequestParam("password")String password) {
		User user = userService.findByUsernameAndPassword(username,password);
		for(User utente : userService.listaUtenti()) {
			if((utente.getUsername().equals(username)) && (utente.getPassword().equals(password))) {
				return"redirect:/played";
			}
		}
		return "redirect:/registrazione";
	}

	@RequestMapping("/registrazione")
	public String registrazione(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "registrazione";
	}

	@RequestMapping("/registra")
	public String registra(@ModelAttribute("user")User user) {
		userService.save(user);
		return "redirect:/";
	}

	@RequestMapping("/trovauser")
	public String trovaUser(@RequestParam("username")String username,Model model) {
		List<User>utenti = userService.trovaPerUsername(username);
		model.addAttribute("utenti",utenti);
		return "registrazione";
	}


}
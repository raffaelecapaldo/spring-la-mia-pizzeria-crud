package org.java.app.business.controller;

import java.util.List;

import org.java.app.business.db.pojo.Pizza;
import org.java.app.business.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getIndex(Model model, @RequestParam(required = false) String name) {
		
		List<Pizza> pizzas = name == null ?
							 pizzaService.findAll():
							 pizzaService.findByName(name);
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("name", name);
		
		return "pizza/pizza-index";
	}
	
	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);
		
		return "pizza/pizza-show";
	}
	
	@GetMapping("/create")
	public String getCreateForm(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "pizza/pizza-create";
	}
	
	@PostMapping("/create")
	public String storePizza(@Valid @ModelAttribute Pizza pizza, BindingResult bindingResult, Model model) {
		pizzaService.save(pizza);
		
		return "redirect:/pizzas";
	}
	
}

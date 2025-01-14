package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@RequiredArgsConstructor
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;

	@PostMapping
	public PizzaDTO Register(@Valid @RequestBody PizzaDTO dto) {
		return pizzaService.CreateRegister(dto);

	}

	@GetMapping
	public List<PizzaDTO> FindAll(){
		return pizzaService.FindPizza();

	}

}


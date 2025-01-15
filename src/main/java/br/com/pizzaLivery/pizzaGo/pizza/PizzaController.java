package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/{id}")
	public PizzaDTO GetById(@PathVariable Long id){
		return pizzaService.FindPizzaById(id);
	}

	@PutMapping("/{id}")
	public PizzaDTO PutPizza(@PathVariable Long id,@RequestBody PizzaDTO dto){
		return pizzaService.UpdatePizza(id, dto);
	}

	@DeleteMapping("/{id}")
	public String DeleteById(@PathVariable Long id){
		return pizzaService.DeletePizzaById(id);
	}

}


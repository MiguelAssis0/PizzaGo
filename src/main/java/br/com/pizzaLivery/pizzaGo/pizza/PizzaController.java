package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pizza")
@RequiredArgsConstructor
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;

	@PostMapping
	public ResponseEntity<PizzaDTO> Register(@Valid @RequestBody PizzaDTO dto, UriComponentsBuilder uriBuilder) {
		PizzaDTO createPizza = pizzaService.CreateRegister(dto);
		URI address = uriBuilder.path("/pizza/{id}").buildAndExpand(createPizza.id).toUri();
		return ResponseEntity.created(address).body(createPizza);

	}

	@GetMapping
	public ResponseEntity<Page<PizzaDTO>> FindAll(@PageableDefault(size = 10)Pageable pageable){
		Page<PizzaDTO> pizzas = pizzaService.FindPizza(pageable);
		return ResponseEntity.ok(pizzas);

	}

	@GetMapping("/{id}")
	public ResponseEntity<PizzaDTO> GetById(@PathVariable Long id){
		PizzaDTO pizzaById = pizzaService.FindPizzaById(id);
		return ResponseEntity.ok(pizzaById);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PizzaDTO> PutPizza(@PathVariable Long id,@RequestBody PizzaDTO dto){
		PizzaDTO pizzaUpdate = pizzaService.UpdatePizza(id, dto);
		return ResponseEntity.ok(pizzaUpdate);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteById(@PathVariable Long id){
		pizzaService.DeletePizzaById(id);
		return ResponseEntity.noContent().build();
	}

}


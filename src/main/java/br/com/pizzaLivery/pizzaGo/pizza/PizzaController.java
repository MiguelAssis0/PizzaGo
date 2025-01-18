package br.com.pizzaLivery.pizzaGo.pizza;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pizza")
@SecurityRequirement(name = "bearer-key")
public class PizzaController {

	private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)

	public ResponseEntity<PizzaDTO> Register(@Valid @RequestBody PizzaDTO dto, UriComponentsBuilder uriBuilder) {
		PizzaDTO createPizza = pizzaService.CreateRegister(dto);
		URI address = uriBuilder.path("/pizza/{id}").buildAndExpand(createPizza.getId()).toUri();
		return ResponseEntity.created(address).body(createPizza);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<PizzaDTO>> FindAll(@PageableDefault(size = 10) Pageable pageable) {
		Page<PizzaDTO> pizzas = pizzaService.FindPizza(pageable);
		return ResponseEntity.ok(pizzas);

	}

	@GetMapping(
			value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PizzaDTO> GetById(@PathVariable Long id) {
		PizzaDTO pizzaById = pizzaService.FindPizzaById(id);
		return ResponseEntity.ok(pizzaById);
	}

	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<PizzaDTO> PutPizza(@PathVariable Long id, @RequestBody PizzaDTO dto) {
		PizzaDTO pizzaUpdate = pizzaService.UpdatePizza(id, dto);
		return ResponseEntity.ok(pizzaUpdate);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteById(@PathVariable Long id) {
		pizzaService.DeletePizzaById(id);
		return ResponseEntity.noContent().build();
	}
}


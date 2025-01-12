package pizza;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PizzaService {
	private final PizzaRepository pizzaRepository;
}

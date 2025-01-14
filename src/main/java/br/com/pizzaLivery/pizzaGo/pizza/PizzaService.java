package br.com.pizzaLivery.pizzaGo.pizza;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    private final ModelMapper modelMapper;

    public PizzaService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PizzaDTO CreateRegister(PizzaDTO dto) {
        Pizza pizza = new Pizza(dto.name, dto.price, dto.avaliable, dto.size, dto.flavor);
        pizzaRepository.save(pizza);
        return dto;
    }

    public List<PizzaDTO> FindPizza(){
        List<Pizza> pizzas = pizzaRepository.findAll();
        return pizzas.stream()
                .map(pizza -> new PizzaDTO(pizza.name, pizza.price, pizza.size, pizza.flavor, pizza.avaliable))
                .collect(Collectors.toList());
    }
}



package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) { this.pizzaRepository = pizzaRepository; }

    public PizzaDTO CreateRegister(PizzaDTO dto) {
        Pizza pizza = new Pizza(dto.getName(), dto.getPrice(), dto.getAvaliable(), dto.getSize(),dto.getFlavor(),dto.getCategorys());
        pizzaRepository.save(pizza);
        return new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice(), pizza.getSize(), pizza.getFlavor(), pizza.getAvaliable(), pizza.getCategorys());
    }

    public Page<PizzaDTO> FindPizza(Pageable pageable){
        return pizzaRepository
                .findAll(pageable)
                .map(pizza -> new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice(), pizza.getSize(), pizza.getFlavor(), pizza.getAvaliable(), pizza.getCategorys()));

    }

    public PizzaDTO FindPizzaById(Long id){
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice(), pizza.getSize(), pizza.getFlavor(), pizza.getAvaliable(), pizza.getCategorys());
    }

    public PizzaDTO UpdatePizza(Long id, PizzaDTO dto) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(dto.getName() != null) pizza.setName(dto.getName());
        if(dto.getPrice() > 0 && dto.getPrice() != pizza.getPrice()) pizza.setPrice(dto.getPrice());
        if(dto.getAvaliable() != null) pizza.setAvaliable(dto.getAvaliable());
        if(dto.getSize() != null) pizza.setSize(dto.getSize());
        if(dto.getFlavor() != null) pizza.setFlavor(dto.getFlavor());
        if(dto.getCategorys() != null) pizza.setCategorys(dto.getCategorys());

        pizzaRepository.save(pizza);

        return new PizzaDTO(pizza.getId(), pizza.getName(), pizza.getPrice(), pizza.getSize(),
                pizza.getFlavor(), pizza.getAvaliable(), pizza.getCategorys());
    }

    public void DeletePizzaById(Long id){
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        pizzaRepository.delete(pizza);
    }


}

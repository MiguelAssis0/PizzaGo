package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public PizzaDTO CreateRegister(PizzaDTO dto) {
        Pizza pizza = new Pizza(dto.name, dto.price, dto.avaliable, dto.size, dto.flavor, dto.categorys);
        pizzaRepository.save(pizza);
        PizzaDTO PizzaCreated = new PizzaDTO(pizza.id, pizza.name, pizza.price, pizza.size, pizza.flavor, pizza.avaliable, pizza.categorys);
        return PizzaCreated;
    }

    public Page<PizzaDTO> FindPizza(Pageable pageable){
        return pizzaRepository
                .findAll(pageable)
                .map(pizza -> new PizzaDTO(pizza.id, pizza.name, pizza.price, pizza.size, pizza.flavor, pizza.avaliable, pizza.categorys));

    }

    public PizzaDTO FindPizzaById(Long id){
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new PizzaDTO(pizza.id, pizza.name, pizza.price, pizza.size, pizza.flavor, pizza.avaliable, pizza.categorys);
    }

    public PizzaDTO UpdatePizza(Long id, PizzaDTO dto) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if(dto.name != null) pizza.name = dto.name;
        if(dto.price > 0 && dto.price != pizza.price) pizza.price = dto.price;
        if(dto.avaliable != null) pizza.avaliable = dto.avaliable;
        if(dto.size != null) pizza.size = dto.size;
        if(dto.flavor != null) pizza.flavor = dto.flavor;
        if(dto.categorys != null) pizza.categorys = dto.categorys;

        pizzaRepository.save(pizza);

        return new PizzaDTO(pizza.id, pizza.name, pizza.price, pizza.size,
                pizza.flavor, pizza.avaliable, pizza.categorys);
    }

    public void DeletePizzaById(Long id){
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        pizzaRepository.delete(pizza);
    }


}

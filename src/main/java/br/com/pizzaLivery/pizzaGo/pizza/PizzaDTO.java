package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PizzaDTO {
    public Long id;
    @NotBlank
    public String name;
    @Positive
    public double price;
    public Boolean avaliable;
    public Flavor flavor;
    public Size size;
    public Categorys categorys;

    public PizzaDTO(){}

    public PizzaDTO(String name, double price, Size size, Flavor flavor, Boolean avaliable, Categorys categorys) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.flavor = flavor;
        this.avaliable = avaliable;
        this.categorys = categorys;
    }

    public PizzaDTO(Long id, String name, double price, Size size, Flavor flavor, Boolean avaliable, Categorys categorys) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.flavor = flavor;
        this.avaliable = avaliable;
        this.categorys = categorys;
        this.id = id;
    }
}


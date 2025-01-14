package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class PizzaDTO {
    @NotNull (message = "Name is required")
    public String name;

    @NotNull(message = "Price is required")
    public double price;

    @NotNull(message = "Available status is required")
    public boolean avaliable;

    public Flavor flavor;
    public Size size;

    public PizzaDTO(String name, double price, Size size, Flavor flavor, boolean avaliable) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.flavor = flavor;
        this.avaliable = avaliable;
    }
}


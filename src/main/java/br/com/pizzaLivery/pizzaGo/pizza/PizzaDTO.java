package br.com.pizzaLivery.pizzaGo.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
    private Long id;
    @NotBlank
    private String name;
    @Positive
    private double price;
    private Boolean avaliable;
    private Flavor flavor;
    private Size size;
    private Categorys categorys;

    public PizzaDTO(){}

    public PizzaDTO(String name, double price, Size size, Flavor flavor, Boolean avaliable, Categorys categorys) {
        this.name = name;
        this.price = price;
        this.avaliable = avaliable;
        this.categorys = categorys;
        this.flavor = flavor;
        this.size = size;
    }

    public PizzaDTO(Long id, String name, double price, Size size, Flavor flavor, Boolean avaliable, Categorys categorys) {
        this.name = name;
        this.price = price;
        this.avaliable = avaliable;
        this.categorys = categorys;
        this.flavor = flavor;
        this.size = size;
        this.id = id;
    }

    // Getters e Setters públicos
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public Boolean getAvaliable() { return avaliable; }
    public Flavor getFlavor() { return flavor; }
    public Size getSize() { return size; }
    public Categorys getCategorys() { return categorys; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setAvaliable(Boolean avaliable) { this.avaliable = avaliable; }
    public void setFlavor(Flavor flavor) { this.flavor = flavor; }
    public void setSize(Size size) { this.size = size; }
    public void setCategorys(Categorys categorys) { this.categorys = categorys; }
}
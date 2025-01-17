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
        setName(name);
        setPrice(price);
        setAvaliable(avaliable);
        setCategorys(categorys);
        setFlavor(flavor);
        setSize(size);
    }

    public PizzaDTO(Long id, String name, double price, Size size, Flavor flavor, Boolean avaliable, Categorys categorys) {
        setName(name);
        setPrice(price);
        setAvaliable(avaliable);
        setCategorys(categorys);
        setFlavor(flavor);
        setSize(size);
        setId(id);
    }

    protected Long getId() { return id; }
    protected String getName() { return name; }
    protected double getPrice() { return price; }
    protected Boolean getAvaliable() { return avaliable; }
    protected Flavor getFlavor() { return flavor; }
    protected Size getSize() { return size; }
    protected Categorys getCategorys() { return categorys; }

    private void setId(Long id) { this.id = id; }
    private void setName(String name) { this.name = name; }
    private void setPrice(double price) { this.price = price; }
    private void setAvaliable(Boolean avaliable) { this.avaliable = avaliable; }
    private void setFlavor(Flavor flavor) { this.flavor = flavor; }
    private void setSize(Size size) { this.size = size; }
    private void setCategorys(Categorys categorys) { this.categorys = categorys; }
}


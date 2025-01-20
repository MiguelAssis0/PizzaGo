package br.com.pizzaLivery.pizzaGo.pizza;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "pizza")
@Getter
@Setter
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private Boolean avaliable;

	@Enumerated(EnumType.STRING)
	private Flavor flavor;

	@Enumerated(EnumType.STRING)
	private Size size;

	@Enumerated(EnumType.STRING)
	private Categorys categorys;

	public Pizza(){}

	public Pizza(String name, double price, Boolean avaliable, Size size, Flavor flavor, Categorys categorys) {
		setName(name);
		setPrice(price);
		setAvaliable(avaliable);
		setCategorys(categorys);
		setFlavor(flavor);
		setSize(size);
	}

	protected Long getId() { return id; }
	protected String getName() { return name; }
	protected double getPrice() { return price; }
	protected Boolean getAvaliable() { return avaliable; }
	protected Flavor getFlavor() { return flavor; }
	protected Size getSize() { return size; }
	protected Categorys getCategorys() { return categorys; }

	protected void setName(String name) { this.name = name; }
	protected void setPrice(double price) { this.price = price; }
	protected void setAvaliable(Boolean avaliable) { this.avaliable = avaliable; }
	protected void setFlavor(Flavor flavor) { this.flavor = flavor; }
	protected void setSize(Size size) { this.size = size; }
	protected void setCategorys(Categorys categorys) { this.categorys = categorys; }
}

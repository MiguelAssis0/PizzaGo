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
@NoArgsConstructor
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public double price;
	public Boolean avaliable;

	@Enumerated(EnumType.STRING)
	public Flavor flavor;

	@Enumerated(EnumType.STRING)
	public Size size;

	@Enumerated(EnumType.STRING)
	public Categorys categorys;

	public Pizza(){}

	public Pizza(String name, double price, Boolean avaliable, Size size, Flavor flavor, Categorys categorys) {
		this.name = name;
		this.price = price;
		this.avaliable = avaliable;
		this.flavor = flavor;
		this.size = size;
		this.categorys = categorys;
	}
}

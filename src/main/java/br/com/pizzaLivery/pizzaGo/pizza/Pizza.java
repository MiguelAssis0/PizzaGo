package br.com.pizzaLivery.pizzaGo.pizza;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	public double price;
	public boolean avaliable;
	@Enumerated(EnumType.STRING)
	public Flavor flavor;
	@Enumerated(EnumType.STRING)
	public Size size;

	public Pizza(){}

	public Pizza(@NotNull(message = "Name is required") String name, @NotNull(message = "Price is required") double price, @NotNull(message = "Available status is required") boolean avaliable, Size size, Flavor flavor) {
		this.name = name;
		this.price = price;
		this.avaliable = avaliable;
		this.flavor = flavor;
		this.size = size;
	}
}

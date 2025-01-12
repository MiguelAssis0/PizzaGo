package pizza;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDTO {
	private String name;
	private double price;
	private boolean avaliable;
	private Size size;
	private Flavor flavor;
}

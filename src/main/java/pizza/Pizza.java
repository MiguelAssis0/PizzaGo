package pizza;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pizza")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private boolean avaliable;
	@Enumerated(EnumType.STRING)
	private Flavor flavor;
	@Enumerated(EnumType.STRING)
	private Size size;
	
}

package br.com.pizzaLivery.pizzaGo.user;

import br.com.pizzaLivery.pizzaGo.pizza.Pizza;
import br.com.pizzaLivery.pizzaGo.pizza.PizzaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Users, Long> {



    UserDetails findByUsername(String username);


}

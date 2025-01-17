package br.com.pizzaLivery.pizzaGo.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User(){}

    public User(String login,String password){
        setLogin(login);
        setPassword(password);
    }

    private void setLogin(String username){ this.username = username; }
    protected String getLogin(){ return this.username; }

    private void setPassword(String password) { this.password = password; }
    protected String getPassword(){ return this.password; }



}

package br.com.pizzaLivery.pizzaGo.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;

    public User(){}

    public User(String login,String password){
        setLogin(login);
        setPassword(password);
    }

    private void setLogin(String login){ this.login = login; }
    public String getLogin(){ return this.login; }

    private void setPassword(String password) { this.password = password; }
    public String getPassword(){ return this.password; }



}

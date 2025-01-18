package br.com.pizzaLivery.pizzaGo.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public Users(){}

    public Users(String username, String password){
        setLogin(username);
        setPassword(password);
    }

    private void setLogin(String username){ this.username = username; }
    public String getUsername(){ return this.username; }


    protected Long getId() { return this.id; }


    public void setPassword(String password) { this.password = password; }
    public String getPassword(){ return this.password; }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }





}

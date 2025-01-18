package br.com.pizzaLivery.pizzaGo.user;

import br.com.pizzaLivery.pizzaGo.config.EncryptPassword;
import br.com.pizzaLivery.pizzaGo.pizza.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public DataUsersLogin createUser(DataUsersLogin dto){
        Users user = new Users(dto.getUsername(),dto.getPassword());
        String encryptedPassword = EncryptPassword.encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return new DataUsersLogin(user.getId(), user.getUsername(),user.getPassword());
    }
}

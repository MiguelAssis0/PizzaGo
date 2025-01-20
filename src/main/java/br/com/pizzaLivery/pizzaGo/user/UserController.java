package br.com.pizzaLivery.pizzaGo.user;

import com.fasterxml.jackson.core.TreeNode;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody @Valid DataUsersLogin dto, UriComponentsBuilder uri){
        DataUsersLogin dataUsers = userService.createUser(dto);
        URI address = uri.path("/users/{id}").buildAndExpand(dataUsers.getId()).toUri();
        return ResponseEntity.created(address).build();
    }


}

package br.com.pizzaLivery.pizzaGo.user;

import com.fasterxml.jackson.core.TreeNode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody @Valid DataUsersLogin dto, UriComponentsBuilder uri){
        DataUsersLogin dataUsers = userService.createUser(dto);
        URI address = uri.path("/users/{id}").buildAndExpand(dataUsers.getId()).toUri();
        return ResponseEntity.created(address).build();
    }


}
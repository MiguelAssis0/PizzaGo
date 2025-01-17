package br.com.pizzaLivery.pizzaGo.user;


import jakarta.validation.constraints.NotBlank;

public class UserCredentialsDTO {

    @NotBlank
    private String username;
    private String password;

    public UserCredentialsDTO(){}
    public UserCredentialsDTO(String username,String password){
        setUsername(username);
        setPassword(password);
    }

    private void setUsername(String username) { this.username = username; }
    protected String getUsername() { return username; }

    private void setPassword(String password) { this.password = password; }
    protected String getPassword() { return password; }
}

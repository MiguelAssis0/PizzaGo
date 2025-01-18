package br.com.pizzaLivery.pizzaGo.user;

import jakarta.validation.constraints.NotBlank;

public class DataUsersLogin {
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public DataUsersLogin(){}
    public DataUsersLogin(Long id, String username,String password){
        setId(id);
        setUsername(username);
        setPassword(password);
    }

    private  void setId(Long id){ this.id = id; }
    public Long getId() { return this.id; }

    private void setUsername(String username) { this.username = username; }
    protected String getUsername() { return username; }

    private void setPassword(String password) { this.password = password; }
    protected String getPassword() { return password; }
}

package br.com.nicolas.projeto_user_authentication.dto;

import br.com.nicolas.projeto_user_authentication.entity.UserEntity;
import org.springframework.beans.BeanUtils;

public class UserDTO {

    public UserDTO(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }

    public UserDTO() {

    }

    private Long id;

    private String name;

    private String login;

    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package br.com.nicolas.projeto_user_authentication.dto;

public class AccessDTO {

    private String token;

    //TODO implementar retornar usuário e authorities

    public AccessDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

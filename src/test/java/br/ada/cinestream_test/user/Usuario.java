package br.ada.cinestream_test.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Usuario {

    private Long id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("email")
    private String email;

    private List<Long> filmesFavoritos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFilmesFavoritos() {
        return filmesFavoritos;
    }

    public void setFilmesFavoritos(List<Long> filmesFavoritos) {
        this.filmesFavoritos = filmesFavoritos;
    }
}

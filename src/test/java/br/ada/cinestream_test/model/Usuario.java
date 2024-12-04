package br.ada.cinestream_test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Usuario {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String nome;
    private String nickName;

    @JsonProperty("email")
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<FilmeFavorito> filmesFavoritos;

    @OneToMany(mappedBy = "usuario")
    private List<SerieFavorita> seriesFavoritas;

    // Construtores, getters e setters
    public Usuario() {
    }

    public Usuario(Long id, String nome, String nickName, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.nickName = nickName;
        this.email = email;
        this.senha = senha;
    }

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<FilmeFavorito> getFilmesFavoritos() {
        return filmesFavoritos;
    }

    public void setFilmesFavoritos(List<FilmeFavorito> filmesFavoritos) {
        this.filmesFavoritos = filmesFavoritos;
    }

    public List<SerieFavorita> getSeriesFavoritas() {
        return seriesFavoritas;
    }

    public void setSeriesFavoritas(List<SerieFavorita> seriesFavoritas) {
        this.seriesFavoritas = seriesFavoritas;
    }

}

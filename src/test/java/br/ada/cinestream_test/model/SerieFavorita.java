package br.ada.cinestream_test.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class SerieFavorita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serieId;
    private Long tmdbId;
    private String titulo;

    @ManyToOne(optional = false)
    private Usuario usuario;
    @javax.persistence.Id
    private Long id;

    public SerieFavorita() {}

    public Long getSerieId() {
        return serieId;
    }

    public void setSerieId(Long id) {
        this.serieId = id;
    }

    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

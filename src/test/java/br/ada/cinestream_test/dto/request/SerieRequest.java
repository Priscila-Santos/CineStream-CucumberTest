package br.ada.cinestream_test.dto.request;

public class SerieRequest {
    private String titulo;

    public SerieRequest() {}

    public SerieRequest(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

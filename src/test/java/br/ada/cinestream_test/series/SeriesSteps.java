package br.ada.cinestream_test.series;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SeriesSteps {

    private String titulo;

    @Dado("que o usuário informa o título {string}")
    public void que_o_usuário_informa_o_título(String titulo) {
        this.titulo = titulo;
    }

    @Quando("o usuário realiza a busca")
    public void o_usuário_realiza_a_busca() {
        given().param("query", titulo).when().get("/search/tv").then().statusCode(200);
    }

    @Entao("a API retorna os detalhes da série {string}")
    public void a_API_retorna_os_detalhes_da_série(String esperado) {
        given().param("query", titulo)
                .when().get("/search/tv")
                .then().body("results[0].name", equalTo(esperado));
    }
}

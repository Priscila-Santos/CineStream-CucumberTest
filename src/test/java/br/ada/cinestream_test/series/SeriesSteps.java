package br.ada.cinestream_test.series;

import br.ada.cinestream_test.dto.request.SerieFavoritaRequest;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SeriesSteps {

    private Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Dado("que o servidor está em execução")
    public void que_o_servidor_está_em_execução() {
        // Verificar se o servidor está em execução (não necessário para testes simples)
    }

    @Quando("o cliente solicita todas as séries na página {int}")
    public void o_cliente_solicita_todas_as_séries_na_página(Integer page) {
        response = given().param("page", page).get("/series/all-series");
    }

    @Entao("a resposta deve conter a série {string}")
    public void a_resposta_deve_conter_a_série(String serie) {
        response.then().statusCode(200)
                .body("content.find { it.name == '%s' }", equalTo(serie));
    }

    @Quando("o cliente solicita a lista de gêneros de séries")
    public void o_cliente_solicita_a_lista_de_gêneros_de_séries() {
        response = given().get("/series/genres-series");
    }

    @Entao("a resposta deve conter o gênero {string}")
    public void a_resposta_deve_conter_o_gênero(String genero) {
        response.then().statusCode(200)
                .body("genres.find { it.name == '%s' }", equalTo(genero));
    }

    @Quando("o cliente busca a série com título {string} na página {int}")
    public void o_cliente_busca_a_série_com_título_na_página(String titulo, Integer page) {
        response = given().param("titulo", titulo).param("page", page).get("/series");
    }

    @Quando("o cliente adiciona a série favorita {string}")
    public void o_cliente_adiciona_a_série_favorita(String serie) {
        SerieFavoritaRequest request = new SerieFavoritaRequest();
        request.setIdSerie(1L); // ID fictício
        response = given().body(request).post("/series/favorita");
    }

    @Entao("a resposta deve ter o status {int}")
    public void a_resposta_deve_ter_o_status(Integer status) {
        response.then().statusCode(status);
    }
}

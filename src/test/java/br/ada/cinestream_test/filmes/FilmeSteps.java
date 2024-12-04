package br.ada.cinestream_test.filmes;

import br.ada.cinestream_test.dto.request.FilmeFavoritoRequest;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FilmeSteps {

    private Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Dado("que o servidor está em execução")
    public void que_o_servidor_está_em_execução() {
        // Verificar se o servidor está em execução (não necessário para testes simples)
    }

    @Quando("o cliente solicita todos os filmes na página {int}")
    public void o_cliente_solicita_todos_os_filmes_na_página(Integer page) {
        response = given().param("page", page).get("/filmes/all-filmes");
    }

    @Entao("a resposta deve conter o filme {string}")
    public void a_resposta_deve_conter_o_filme(String filme) {
        response.then().statusCode(200)
                .body("content.find { it.name == '%s' }", equalTo(filme));
    }

    @Quando("o cliente solicita a lista de gêneros de filmes")
    public void o_cliente_solicita_a_lista_de_gêneros_de_filmes() {
        response = given().get("/filmes/genres-filmes");
    }

    @Entao("a resposta deve conter o gênero {string}")
    public void a_resposta_deve_conter_o_gênero(String genero) {
        response.then().statusCode(200)
                .body("genres.find { it.name == '%s' }", equalTo(genero));
    }

    @Dado("o cliente busca o filme com título {string} na página {int}")
    public void o_cliente_busca_o_filme_com_título_na_página(String titulo, Integer page) {
        response = given().param("titulo", titulo).param("page", page).get("/filmes");
    }

    @Quando("o cliente adiciona o filme favorito {string}")
    public void o_cliente_adiciona_o_filme_favorito(String filme) {
        FilmeFavoritoRequest request = new FilmeFavoritoRequest();
        request.setIdFilme(1L); // ID fictício
        response = given().body(request).post("/filmes/favorito");
    }

    @Entao("a resposta deve ter o status {int}")
    public void a_resposta_deve_ter_o_status(Integer status) {
        response.then().statusCode(status);
    }
}


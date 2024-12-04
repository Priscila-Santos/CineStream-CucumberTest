package br.ada.cinestream_test.usuarios;

import br.ada.cinestream_test.dto.request.UsuarioRequest;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsuarioSteps {

    private Response response;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Dado("que o servidor está em execução")
    public void que_o_servidor_está_em_execução() {
        // Verificar se o servidor está em execução (não necessário para testes simples)
    }

    @Quando("o cliente cria um novo usuário com email {string} e nome {string}")
    public void o_cliente_cria_um_novo_usuário_com_email_e_nome(String email, String nome) {
        UsuarioRequest request = new UsuarioRequest();
        request.setEmail(email);
        request.setNome(nome);

        response = given()
                .contentType("application/json")
                .body(request)
                .post("/usuarios");
    }

    @Então("a resposta deve ter o status {int}")
    public void a_resposta_deve_ter_o_status(Integer status) {
        response.then().statusCode(status);
    }

    @Dado("que o usuário com email {string} existe")
    public void que_o_usuário_com_email_existe(String email) {
        UsuarioRequest request = new UsuarioRequest();
        request.setEmail(email);
        request.setNome("Teste");

        given()
                .contentType("application/json")
                .body(request)
                .post("/usuarios")
                .then()
                .statusCode(201);
    }

    @Quando("o cliente busca o usuário por email {string}")
    public void o_cliente_busca_o_usuário_por_email(String email) {
        response = given().param("email", email).get("/usuarios");
    }

    @Então("a resposta deve conter o email {string}")
    public void a_resposta_deve_conter_o_email(String email) {
        response.then().statusCode(200)
                .body("email", equalTo(email));
    }

    @Dado("que o usuário com ID {int} tem filmes favoritos")
    public void que_o_usuário_com_id_tem_filmes_favoritos(Integer id) {
        // Assumimos que o usuário já tem filmes favoritos, ou podemos adicionar um filme favorito aqui
    }

    @Quando("o cliente solicita os filmes favoritos do usuário com ID {int}")
    public void o_cliente_solicita_os_filmes_favoritos_do_usuário_com_id(Integer id) {
        response = given().get("/usuarios/" + id + "/filmes-favoritos");
    }

    @Então("a resposta deve conter o filme {string}")
    public void a_resposta_deve_conter_o_filme(String filme) {
        response.then().statusCode(200)
                .body("[0].name", equalTo(filme));
    }

    @Dado("que o usuário com ID {int} tem séries favoritas")
    public void que_o_usuário_com_id_tem_séries_favoritas(Integer id) {
        // Assumimos que o usuário já tem séries favoritas, ou podemos adicionar uma série favorita aqui
    }

    @Quando("o cliente solicita as séries favoritas do usuário com ID {int}")
    public void o_cliente_solicita_as_séries_favoritas_do_usuário_com_id(Integer id) {
        response = given().get("/usuarios/" + id + "/series-favoritas");
    }

    @Então("a resposta deve conter a série {string}")
    public void a_resposta_deve_conter_a_série(String serie) {
        response.then().statusCode(200)
                .body("[0].name", equalTo(serie));
    }
}

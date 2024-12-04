package br.ada.cinestream_test.user;

import br.ada.cinestream_test.restassured.RestAssuredUtil;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class UserStepsDefinition {

    private Response response;
    private Usuario usuario;

    @Dado("usuario nao cadastrado")
    public void usuarioNaoCadastrado() {
        usuario = new Usuario();
        usuario.setNome(RandomStringUtils.randomAlphabetic(20));
        usuario.setEmail(RandomStringUtils.randomAlphabetic(10) + "@test.com");
        usuario.setFilmesFavoritos(List.of());
    }

    @Quando("eu crio um usuario com o e-mail {string} e o nome {string}")
    public void criarUsuario(String email, String nome) {
        usuario.setEmail(email);
        usuario.setNome(nome);
        response = RestAssuredUtil.produces()
                .body(usuario)
                .when().post("/usuarios");
    }

    @Entao("o usuario deve ser criado com sucesso")
    public void sucesso() {
        response.then().statusCode(HttpStatus.SC_CREATED);
    }

    @E("exibe resultado da requisicao")
    public void exibeResponse() {
        response.prettyPrint();
    }

    @E("usuario deve possuir id")
    public void validaPossuiId() {
        var id = response.jsonPath().get("id");
        Assertions.assertNotNull(id);
    }

    @Dado("usuario ja cadastrado na base")
    public void usuarioJaCadastrado() {
        usuario = new Usuario();
        usuario.setNome(RandomStringUtils.randomAlphabetic(50));
        usuario.setEmail("william_cesar_santos@hotmail.com");
        usuario.setFilmesFavoritos(List.of(1L, 2L, 3L));
        RestAssuredUtil.produces()
                .body(usuario)
                .when().post("/usuarios");
    }

    @Quando("busco os filmes favoritos para o usuario com o e-mail {string}")
    public void buscarFilmesFavoritos(String email) {
        response = RestAssuredUtil.produces()
                .when().get("/usuarios/" + email + "/filmes-favoritos");
        response.prettyPrint();
    }

    @Entao("eu deveria ver a lista de filmes favoritos")
    public void validaFilmesFavoritos() {
        var filmes = response.jsonPath().getList("");
        Assertions.assertNotNull(filmes);
        Assertions.assertFalse(filmes.isEmpty());
    }

    @E("resposta da requisicao tenha status igual a {int}")
    public void validarStatus(int status) {
        response.then().statusCode(status);
    }
}

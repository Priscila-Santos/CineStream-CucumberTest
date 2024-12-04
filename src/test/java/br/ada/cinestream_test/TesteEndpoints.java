//package br.ada.cinestream_test;
//
//import br.ada.cinestream_test.dto.request.FilmeFavoritoRequest;
//import br.ada.cinestream_test.dto.request.SerieFavoritaRequest;
//import br.ada.cinestream_test.dto.request.UsuarioRequest;
//import br.ada.cinestream_test.restassured.RestAssuredUtil;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//import io.restassured.parsing.Parser;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
//
//public class TesteEndpoints {
//
//    static {
//        RestAssured.defaultParser = Parser.JSON;
//    }
//
//    @Test
//    void testarSeriesEndpoint() {
//        Response response = RestAssuredUtil.produces().get("/series/all-series");
//        response.then().statusCode(200)
//                .body("content[0].name", equalTo("Lost"));
//    }
//
//    @Test
//    void testarGenerosSeriesEndpoint() {
//        Response response = RestAssuredUtil.produces().get("/series/genres-series");
//        response.then().statusCode(200)
//                .body("genres[0].name", equalTo("Ação"));
//    }
//
//    @Test
//    void buscarPorTitulo() {
//        Response response = RestAssuredUtil.produces()
//                .param("titulo", "Lost")
//                .get("/series");
//        response.then().statusCode(200)
//                .body("results[0].name", equalTo("Lost"));
//    }
//
//    @Test
//    void buscarSeriesFavoritas() {
//        Response response = RestAssuredUtil.produces().get("/usuarios/1/series-favoritas");
//        response.then().statusCode(200).body("[0].name", equalTo("Lost"));
//    }
//
//    @Test
//    void adicionarSerieFavorita() {
//        SerieFavoritaRequest request = new SerieFavoritaRequest();
//        request.setIdSerie(1L);
//
//        Response response = RestAssuredUtil.produces()
//                .body(request)
//                .post("/series/favorita");
//        response.then().statusCode(201);
//    }
//
//    @Test
//    void testarFilmesEndpoint() {
//        Response response = RestAssuredUtil.produces().get("/filmes/all-filmes");
//        response.then().statusCode(200)
//                .body("results[0].name", equalTo("Inception"));
//    }
//
//    @Test
//    void testarGenerosFilmesEndpoint() {
//        Response response = RestAssuredUtil.produces().get("/filmes/genres-filmes");
//        response.then().statusCode(200).body("genres[0].name", equalTo("Ação"));
//    }
//
//    @Test
//    void buscarFilmePorTitulo() {
//        Response response = RestAssuredUtil.produces()
//                .param("titulo", "Inception")
//                .get("/filmes");
//        response.then().statusCode(200)
//                .body("results[0].name", equalTo("Inception"));
//    }
//
//    @Test
//    void adicionarFilmeFavorito() {
//        FilmeFavoritoRequest request = new FilmeFavoritoRequest();
//        request.setIdFilme(1L);
//        Response response = RestAssuredUtil.produces().body(request).post("/filmes/favorito");
//        response.then().statusCode(201);
//    }
//
//    @Test
//    void criarUsuario() {
//        UsuarioRequest request = new UsuarioRequest();
//        request.setEmail("teste@exemplo.com");
//        request.setNome("Teste");
//        Response response = RestAssuredUtil.produces().body(request).post("/usuarios");
//        response.then().statusCode(201);
//    }
//
//    @Test
//    void buscarUsuarioPorEmail() {
//        Response response = RestAssuredUtil.produces().param("email", "teste@exemplo.com").get("/usuarios");
//        response.then().statusCode(200).body("email", equalTo("teste@exemplo.com"));
//    }
//
//    @Test
//    void buscarFilmesFavoritos() {
//        Response response = RestAssuredUtil.produces().get("/usuarios/1/filmes-favoritos");
//        response.then().statusCode(200).body("[0].name", equalTo("Inception"));
//    }
//
//}
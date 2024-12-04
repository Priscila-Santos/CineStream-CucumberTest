package br.ada.cinestream_test.restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;

public class RestAssuredUtil {

    static {
        RestAssured.defaultParser = Parser.JSON;
    }

    public static RequestSpecification produces() {
        return RestAssured.given()
                .baseUri("http://localhost:8080/")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header(HttpHeaders.AUTHORIZATION, "token");
    }

    public static void main(String[] args) {
        // Testar endpoint de séries
        Response seriesResponse = produces().get("/series/all-series");

        System.out.println("Response from /all-series endpoint:");
        seriesResponse.prettyPrint();
        seriesResponse.then().statusCode(200);

        // Testar endpoint de filmes
        Response moviesResponse = produces().get("/filmes/all-filmes");

        System.out.println("Response from /all-filmes endpoint:");
        moviesResponse.prettyPrint();
        moviesResponse.then().statusCode(200);


    }
}

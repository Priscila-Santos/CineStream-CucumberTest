# **Cine Stream Testes Cucumber**

Bem-vindo ao projeto de testes do CineStream! Este projeto contém testes automatizados para a API do CineStream, utilizando ferramentas como RestAssured, WireMock, Cucumber e JUnit.

## **Sumário**
- [Descrição](#descrição)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Projeto Cine Stream de Testes](#Projeto-Cine-Stream-de-Testes)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar os Testes](#como-executar-os-testes)
  - [Exemplo de Teste Cucumber](#exemplo-de-teste-cucumber)
  - [Exemplo de Testes feitos a partir do Cucumber](#exemplo-de-testes-feitos-a-partir-do-cucumber)


## **Descrição**
Este projeto foi desenvolvido para testar a API do CineStream, garantindo que os endpoints funcionem conforme esperado. Utilizamos uma combinação de testes de integração e de unidade, simulando respostas de APIs externas e verificando a consistência dos dados retornados.

## **Tecnologias Utilizadas**
- **Java 8+**
- **Spring Boot 2.6.1**
- **RestAssured**: Para testes de API REST.
- **WireMock**: Para simular respostas de APIs externas.
- **Cucumber**: Para testes baseados em comportamento (BDD).
- **JUnit 5**: Para execução de testes.

## **Projeto Cine Stream de Testes**
[Repositório do Projeto Cine Stream de Teste](https://github.com/Priscila-Santos/Cine-Stream-Test?tab=readme-ov-file#pr%C3%A9-requisitos)
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cine-stream-test.git
   cd cine-stream-test
   
# Estrutura do projeto
```
cine-stream-test/
├── src/
│   │   
│   └── test/
│       ├── java/
│       │   └── br/
│       │       └── ada/
│       │           └── cinestream_test/
│       │               ├── CinestreamTestApplicationTests.java
│       │               └── restassured/
│       │                   └── RestAssuredUtilTest.java
│       └── resources/
│           └── wiremock/
│               └── responses/
│                   └── search_tv_lost.json
├── pom.xml
└── README.md
```
### Como Executar os Testes
Para executar os testes, use os seguintes comandos:

### Testes de Unidade e Integração
Execute os testes com JUnit:

```bash 
mvn test 
```

### Testes de Comportamento (BDD) com Cucumber

#### Exemplo de Teste Cucumber

```bash 
Funcionalidade: Testar API de Séries

  Cenário: Buscar todas as séries
    Dado que o servidor está em execução
    Quando o cliente solicita todas as séries na página 1
    Então a resposta deve conter a série "Lost"

  Cenário: Buscar gêneros de séries
    Dado que o servidor está em execução
    Quando o cliente solicita a lista de gêneros de séries
    Então a resposta deve conter o gênero "Ação"

  Cenário: Adicionar série favorita
    Dado que o servidor está em execução
    Quando o cliente adiciona a série favorita "Lost"
    Então a resposta deve ter o status 201
```

#### Exemplo de Testes feitos a partir do Cucumber

```bash 
public class SerieSteps {
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
    @Então("a resposta deve conter a série {string}")
    public void a_resposta_deve_conter_a_série(String serie) {
        response.then().statusCode(200)
                .body("content.find { it.name == '%s' }", equalTo(serie));
    }
```



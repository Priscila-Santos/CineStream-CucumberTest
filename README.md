# **CineStream Testes**

Bem-vindo ao projeto de testes do CineStream! Este projeto contém testes automatizados para a API do CineStream, utilizando ferramentas como RestAssured, WireMock, Cucumber e JUnit.

## **Sumário**
- [Descrição](#descrição)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Executar os Testes](#como-executar-os-testes)


## **Descrição**
Este projeto foi desenvolvido para testar a API do CineStream, garantindo que os endpoints funcionem conforme esperado. Utilizamos uma combinação de testes de integração e de unidade, simulando respostas de APIs externas e verificando a consistência dos dados retornados.

## **Tecnologias Utilizadas**
- **Java 8+**
- **Spring Boot 2.6.1**
- **RestAssured**: Para testes de API REST.
- **WireMock**: Para simular respostas de APIs externas.
- **Cucumber**: Para testes baseados em comportamento (BDD).
- **JUnit 5**: Para execução de testes.

## **Pré-requisitos**
Antes de começar, você precisará ter o seguinte instalado:
- **Java JDK 8+**
- **Maven 3.6.3+**

## **Instalação**
Siga os passos abaixo para configurar o projeto localmente:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cine-stream-test.git
   cd cine-stream-test
   
# Estrutura do projeto
```
cine-stream-test/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── br/
│   │           └── ada/
│   │               └── cinestream_test/
│   │                   ├── CineStreamTestApplication.java
│   │                   └── restassured/
│   │                       └── RestAssuredUtil.java
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
Execute os testes com Cucumber:
```bash 
mvn verify -P cucumber
```

# CineStream-CucumberTest

# language: pt

Funcionalidade: Buscar informações sobre séries

 Cenario: Buscar série pelo título
  Dado que o usuário informa o título "Breaking Bad"
  Quando o usuário realiza a busca
  Entao a API retorna os detalhes da série "Breaking Bad"

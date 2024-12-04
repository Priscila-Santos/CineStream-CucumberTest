# language: pt
Funcionalidade: Testar API de Filmes

  Cenario: Buscar todos os filmes
  Dado que o servidor está em execução
  Quando o cliente solicita todos os filmes na página 1
  Entao a resposta deve conter o filme "Inception"

  Cenario: Buscar gêneros de filmes
  Dado que o servidor está em execução
  Quando o cliente solicita a lista de gêneros de filmes
  Entao a resposta deve conter o gênero "Ação"

  Cenario: Buscar filme por título
  Dado que o servidor está em execução
  Quando o cliente busca o filme com título "Inception" na página 1
  Entao a resposta deve conter o filme "Inception"

  Cenario: : Adicionar filme favorito
  Dado que o servidor está em execução
  Quando o cliente adiciona o filme favorito "Inception"
  Entao a resposta deve ter o status 201

# language: pt

Funcionalidade: Buscar informações sobre séries

  Cenario: Buscar série pelo título
  Dado que o usuário informa o título "Lost"
  Quando o usuário realiza a busca
  Entao a API retorna os detalhes da série "Lost"

  Cenario: Buscar todas as séries
  Dado que o servidor está em execução
  Quando o cliente solicita todas as séries na página 1
  Entao a resposta deve conter a série "Lost"

  Cenario: Buscar gêneros de séries
  Dado que o servidor está em execução
  Quando o cliente solicita a lista de gêneros de séries
  Entao a resposta deve conter o gênero "Ação"

  Cenario: Adicionar série favorita
  Dado que o servidor está em execução
  Quando o cliente adiciona a série favorita "Lost"
  Entao a resposta deve ter o status 201


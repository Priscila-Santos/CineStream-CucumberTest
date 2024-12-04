# language: pt

Funcionalidade: Testar API de Usuarios

  Cenario: Buscando filmes favoritos de um usuário
    Dado usuario ja cadastrado na base
    Quando busco os filmes favoritos para o usuario com o e-mail "test@example.com"
    Então eu deveria ver a lista de filmes favoritos
    E resposta da requisicao tenha status igual a 200

  Cenário: Criar um novo usuário
    Dado que o servidor está em execução
    Quando o cliente cria um novo usuário com email "teste@exemplo.com" e nome "Teste"
    Então a resposta deve ter o status 201

  Cenário: Buscar usuário por email
    Dado que o servidor está em execução
    E que o usuário com email "teste@exemplo.com" existe
    Quando o cliente busca o usuário por email "teste@exemplo.com"
    Então a resposta deve conter o email "teste@exemplo.com"

  Cenário: Buscar filmes favoritos do usuário
    Dado que o servidor está em execução
    E que o usuário com ID 1 tem filmes favoritos
    Quando o cliente solicita os filmes favoritos do usuário com ID 1
    Então a resposta deve conter o filme "Inception"

  Cenário: Buscar séries favoritas do usuário
    Dado que o servidor está em execução
    E que o usuário com ID 1 tem séries favoritas
    Quando o cliente solicita as séries favoritas do usuário com ID 1
    Então a resposta deve conter a série "Lost"


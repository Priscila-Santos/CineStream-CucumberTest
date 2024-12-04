# language: pt

Funcionalidade: Gerenciamento de usuários

  Cenario: Criando um novo usuário
    Dado usuario nao cadastrado
    Quando eu crio um usuario com o e-mail "test@example.com" e o nome "Usuário de teste"
    Então o usuario deve ser criado com sucesso
    E exibe resultado da requisicao
    E usuario deve possuir id

  Cenario: Buscando filmes favoritos de um usuário
    Dado usuario ja cadastrado na base
    Quando busco os filmes favoritos para o usuario com o e-mail "test@example.com"
    Então eu deveria ver a lista de filmes favoritos
    E resposta da requisicao tenha status igual a 200

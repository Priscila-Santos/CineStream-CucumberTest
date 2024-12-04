# language: pt

Funcionalidade: Mapeamento de Usuario

  Cenario: Converter UsuarioRequest para Usuario
    Dado um UsuarioRequest com nome "Priscila Santos", nickname "pri" e email "priscila@example.com"
    Quando eu converter para Usuario
    Entao o nome deve ser "Priscila Santos"
    E o nickname deve ser "pri"
    E o email deve ser "priscila@example.com"

Cenario: Converter Usuario para UsuarioResponse
    Dado um Usuario com id 1, nome "Priscila Santos", nickname "pri" e email "priscila@example.com"
    E uma lista de filmes favoritos
    E uma lista de series favoritas
    Quando eu converter para UsuarioResponse
    Entao o id deve ser 1
    E o nome deve ser "Priscila Sanros"
    E o nickname deve ser "pri"
    E o email deve ser "prisciça@example.com"
    E a lista de filmes favoritos deve ter 1 filme
    E a lista de series favoritas deve ter 1 serie

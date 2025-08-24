## Descrição

Projeto desenvolvido em Java + Spring Boot, implementando autenticação e autorização com JWT (JSON Web Token).
O sistema permite o cadastro e autenticação de usuários.
Determinados endpoints só podem ser acessados por usuários autenticados.

## Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Security

JWT (JSON Web Token)

JPA / Hibernate

Banco de Dados MySQL

Maven

## Funcionalidades

Cadastro de usuários

Login com geração de token JWT

Validação do token em cada requisição protegida

CRUD de usuários (criar, listar, atualizar e deletar)

Restrições de acesso em endpoints

## Estrutura do Projeto
```
src/
 └── main/
     ├── java/br/com/nicolas/projeto_user_authentication
     │   ├── controller   # Controllers (endpoints REST)
     │   ├── dto          # DTOs (transferência de dados)
     │   ├── entity       # Entidades (JPA)
     │   ├── repository   # Repositórios JPA
     │   ├── security     # Configurações e filtros JWT
     │   └── service      # Regras de negócio
     └── resources/
         ├── application.properties
```
## Segurança

Senhas criptografadas com BCrypt

Tokens JWT possuem tempo de expiração

Filtros de autenticação aplicados em cada requisição

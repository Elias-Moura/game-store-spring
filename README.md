# Game Store Spring

Este repositório contém um projeto de estudo do framework Spring, que implementa um CRUD básico para uma loja de jogos. O objetivo principal deste projeto é demonstrar a utilização das melhores práticas de desenvolvimento de software, incluindo Clean Code, Princípios SOLID e uso de DTOs (Data Transfer Objects) no contexto do Spring.

## Funcionalidades

- **Cadastro de Jogos**: Você pode adicionar novos jogos à loja, especificando detalhes como nome, gênero, preço, classificação, etc.
- **Consulta de Jogos**: É possível visualizar a lista de jogos disponíveis na loja, bem como detalhes individuais de cada jogo.
- **Atualização de Jogos**: Você pode atualizar as informações de jogos existentes.
- **Exclusão de Jogos**: Jogos não desejados podem ser removidos da loja.

## Boas Práticas de Código

Este projeto adota várias boas práticas de código e arquitetura de software, incluindo:

- **Clean Code**: O código-fonte é escrito de forma clara e legível, seguindo as diretrizes do livro "Clean Code" de Robert C. Martin.
- **SOLID**: Os princípios SOLID (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion) são aplicados para criar um código mais coeso e extensível.
- **DTOs (Data Transfer Objects)**: DTOs são usados para separar a lógica de negócios dos objetos de transferência de dados, melhorando a comunicação entre a camada de controle e a camada de serviço.
- **Padrão MVC**: A aplicação segue o padrão Model-View-Controller (MVC) para separar as preocupações da aplicação de forma eficiente.

## Pré-requisitos

Antes de executar este projeto, certifique-se de ter as seguintes ferramentas e dependências instaladas:

- Java Development Kit (JDK)
- Spring Boot
- Spring Data JPA
- Banco de Dados (por exemplo, MySQL, PostgreSQL, H2)
- IDE de sua escolha (por exemplo, IntelliJ IDEA, Eclipse)

## Executando o Projeto

1. Clone este repositório em sua máquina local:

```bash
git clone https://github.com/seu-usuario/game-store-spring.git

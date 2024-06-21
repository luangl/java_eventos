# Sistema de Gerenciamento de Eventos

## Informações Gerais sobre o Projeto
Este projeto é um sistema de gerenciamento de eventos desenvolvido como parte do trabalho final de desenvolvimento de software. O sistema permite o cadastro de eventos, participantes e check-ins, além de gerar relatórios de participação e exibir estatísticas de engajamento.

### Objetivos
- Aplicar conceitos de orientação a objetos, tratamento de exceções, persistência de dados e boas práticas de codificação.
- Demonstrar criatividade e entendimento na construção de sistemas mais complexos do que um simples CRUD.

### Funcionalidades Principais
- Cadastro de eventos e participantes.
- Registro de check-ins em eventos.
- Geração de relatórios de participação.
- Exibição de estatísticas de engajamento.

## Informações sobre as Classes e suas Relações

### Classes e Relações
- **Pessoa (Classe Abstrata)**: Classe base para `Participante`, contendo atributos comuns como `nome` e `email`.
- **Participante (Herda de Pessoa)**: Representa um participante de um evento, com atributos adicionais como `telefone`.
- **Evento**: Representa um evento, contendo informações como `título`, `data` e a lista de participantes inscritos.
- **Checkin**: Representa o registro de check-in de um participante em um evento.
- **GerenciamentoEventos**: Implementa a interface `Gerenciamento` e gerencia eventos, participantes e check-ins.

### Agregação, Composição e Associação
- **Agregação**: A classe `Evento` agrega uma lista de `Participante` através do relacionamento entre os participantes inscritos e o evento.
- **Composição**: A classe `GerenciamentoEventos` compõe uma lista de `Evento`, `Participante` e `Checkin`, gerenciando-os.
- **Associação**: O `Checkin` associa um `Participante` a um `Evento`.

## Como Executar o Projeto

### Pré-requisitos
- JDK 8 ou superior.
- IDE de sua escolha (IntelliJ, Eclipse, etc.).

### Passos para Executar
1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>

2. Importe o projeto para sua IDE.

3. Compile e execute a classe Main.


Uso do ChatGPT
O ChatGPT foi utilizado para:

Correção de bugs.
Corrigir e otimizar o código durante o desenvolvimento.


Referências e Recursos
-Documentação do Java
-Guia de Clean Code
-Recursos utilizados durante o desenvolvimento foram mencionados ao longo do projeto.
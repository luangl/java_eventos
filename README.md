- Sistema de Gerenciamento de Eventos
Informações Gerais sobre o Projeto
Este projeto consiste em um sistema de gerenciamento de eventos, desenvolvido em Java, que permite aos usuários criar, listar e remover eventos, gerenciar participantes e registrar check-ins. Além disso, oferece funcionalidades avançadas como persistência de dados, geração de relatórios de participação, frequência e estatísticas de engajamento.

Informações sobre as Classes e suas Relações
O projeto utiliza uma estrutura orientada a objetos com várias classes que se relacionam através de agregação, composição e associação:

Evento: Representa um evento com nome e data.

Associação: Participantes podem se inscrever em eventos.
Participante: Representa um participante com nome e email.

Associação: Participantes podem se inscrever em eventos e são registrados nos check-ins.
CheckIn: Relaciona um participante a um evento em uma data específica.

Composição: Um check-in depende diretamente de um evento e de um participante específico.
GerenciadorEventos: Gerencia a criação, listagem e remoção de eventos.

Agregação: Gerencia uma lista de eventos.
GerenciadorParticipantes: Gerencia a criação, listagem e remoção de participantes.

Agregação: Gerencia uma lista de participantes.
GerenciadorCheckIns: Gerencia o registro e a listagem de check-ins.

Agregação: Gerencia uma lista de check-ins.
Persistencia: Classe auxiliar para salvar e carregar dados de eventos, participantes e check-ins em arquivos.

Relatorio: Gera relatórios sobre participação, frequência e estatísticas de engajamento dos eventos.

Como Executar o Projeto
Para executar o projeto, siga os passos abaixo:

Pré-requisitos:

Java JDK 8 ou superior instalado.
IDE Java (recomendado) ou compilador Java instalado.
Configuração:

Clone o repositório Git para o seu ambiente local.
Execução:

Abra o projeto em sua IDE Java.
Compile e execute a classe Main.java.
Interagindo com o Sistema:

Siga as instruções apresentadas no console para gerenciar eventos, participantes, registrar check-ins e gerar relatórios.
Uso do ChatGPT
O ChatGPT foi utilizado neste projeto para fornecer suporte na elaboração da estrutura do sistema, na lógica de programação e na orientação sobre boas práticas de desenvolvimento de software. Ele ajudou a esclarecer dúvidas conceituais e a otimizar a implementação das funcionalidades propostas.

Referências e Recursos
Documentação oficial do Java: https://docs.oracle.com/javase/
Stack Overflow e GitHub foram utilizados para busca de soluções específicas e exemplos práticos durante o desenvolvimento.
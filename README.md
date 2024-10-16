# Tech Challenge Parquimetro

## Visão Geral

Solução criada para gestão de parquimetross. Este projeto está desenvolvido em Java 17 e segue a arquitetura Hexagonal, utilizando Banco de Dados Relacional (MySQL).

## Requisitos

Antes de iniciar, certifique-se de ter os seguintes requisitos atendidos:

- **Java 17**: O projeto utiliza o Java 17. Certifique-se de que sua IDE está configurada com o Java 17.
- **Maven**: Usado para gerenciar dependências e construir o projeto.

## Passos para Configuração

1. **Clone o Repositório:**

   Abra o terminal e clone o repositório usando o comando:

   ```bash
   git clone https://github.com/bpcavalcante/tech-challenge-parquimetro.git

2. **Acesse a Branch main:**

   Depois de clonar o repositório, navegue até o diretório do projeto e altere para a branch main:

   ```bash
   git checkout main

3. **Importe o Projeto na IDE:**

- Abra sua IDE preferida (por exemplo, IntelliJ IDEA ou Eclipse).
- Certifique-se de que o **Java 17** está configurado como JDK.
- Importe o projeto como um projeto Maven existente.

4. **Construir o Projeto:**

   No terminal, dentro do diretório do projeto, execute o comando Maven para construir o projeto, ou em algumas IDE já constroem automaticamente:

   ```bash
   mvn clean install

5. **Executar o Projeto:**
   Depois de construir o projeto, você pode executá-lo diretamente na IDE ou via linha de comando:
   ```bash
   mvn spring-boot:run

  O servidor será iniciado na porta padrão **8080**


6. **Subir o container Docker:**
   Você precisará subir o container com as configurações, que estão no arquivo docker-compose dentro do projeto:
   ```bash
   docker-compose up

  O servidor MySQL será iniciado na porta **3306**
  

6. **Testando o Sistema:**
   Use os comandos curl abaixo para testar as funcionalidades do sistema:
   - **Criar Parquimetro**
     ```bash
     curl --request POST \
     --url http://localhost:8080/parquimetros \
     --header 'Content-Type: application/json' \
     --header 'User-Agent: insomnia/10.0.0' \
     --data '{
     "complemento_endereco": "Sala Presidencial",
     "cep_endereco": "55667-890",
     "valor_hora_parquimetro": 8.00,
     "nome_parquimetro": "Parquímetro Centro Empresarial",
     "numero": "200"
      }'
   - **Iniciar Vaga**
     ```bash
      curl --request POST \
        --url http://localhost:8080/vagas \
        --header 'Content-Type: application/json' \
        --header 'User-Agent: insomnia/10.0.0' \
        --data '{
        "placa": "TXT1233",
        "parquimetro_id": 2
     }'
   - **Encerrar Vaga**
     ```bash
      curl --request PUT \
        --url http://localhost:8080/vagas \
        --header 'Content-Type: application/json' \
        --header 'User-Agent: insomnia/10.0.0' \
        --data '{
      	"placa": "TXT1233",
      	"parquimetro_id": 2,
      	"metodo_pagamento": "credito"
      }'

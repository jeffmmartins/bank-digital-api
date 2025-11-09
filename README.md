# 🏦 Digital Bank API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=spring&logoColor=white" alt="Spring Boot 3.2.5">
  <img src="https://img.shields.io/badge/Database-H2%20(Dev)-red" alt="H2 Database">
  <img src="https://img.shields.io/badge/Docs-Swagger%20(OpenAPI)-blueviolet" alt="Swagger">
  <img src="https://img.shields.io/badge/License-MIT-green" alt="License MIT">
</p>

## 📖 Sobre o Projeto

O **Digital Bank API** é um projeto de backend focado em simular as operações essenciais de um banco digital. Esta API RESTful foi construída com **Java 17** e **Spring Boot 3**, seguindo as melhores práticas de desenvolvimento, como arquitetura em camadas (Controller, Service, Repository) e uso de DTOs para validação e tráfego de dados.

O objetivo deste projeto é solidificar conceitos de desenvolvimento de APIs seguras, robustas e escaláveis, prontas para o mercado.

## ✨ Status Atual

**Em pleno desenvolvimento!**

Recentemente, superei um desafio de configuração de ambiente (`ExceptionInInitializerError`) relacionado à incompatibilidade entre as versões do JDK (17 vs 24) e o Lombok, demonstrando capacidade de depuração e resolução de problemas complexos de build.

## 🚀 Funcionalidades Implementadas

* **Gestão de Clientes:**
  * `POST /api/clientes`: Cadastro de novos clientes (Validado ✅).
  * `GET /api/clientes`: Listagem de todos os clientes.
  * `GET /api/clientes/{id}`: Busca de cliente por ID.
  * `PUT /api/clientes/{id}`: Atualização de dados cadastrais.
  * `DELETE /api/clientes/{id}`: Exclusão de cliente.
* **Gestão de Contas:**
  * `GET /api/contas`: Listagem de todas as contas.
  * `GET /api/contas/{id}`: Busca de conta por ID.
  * `GET /api/contas/cliente/{clienteId}`: Busca de contas por ID do cliente.
* **Operações Bancárias:**
  * `POST /api/transacoes/deposito`: Realiza um depósito em uma conta.
  * `POST /api/transacoes/saque`: Realiza um saque, validando o saldo disponível.
* **Dados Iniciais (Seed):**
  * Um `DataLoader` popula o banco H2 com clientes e contas pré-definidos para facilitar testes.

## 🛠️ Stack Tecnológica

Esta API utiliza um conjunto moderno de tecnologias do ecossistema Spring:

* **Core:** [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) & [Spring Boot 3.2.5](https://spring.io/projects/spring-boot)
* **Persistência de Dados:** [Spring Data JPA](https://spring.io/projects/spring-data-jpa) & [Hibernate](https://hibernate.org/)
* **Banco de Dados (Desenvolvimento):** [H2 Database](https://www.h2database.com/html/main.html) (em memória)
* **API & Web:** [Spring Web](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
* **Validação:** [Spring Boot Starter Validation](https://docs.spring.io/spring-boot/docs/current/reference/html/io.html#io.validation) (para validação de DTOs)
* **Documentação da API:** [SpringDoc (OpenAPI 3)](https://springdoc.org/) (para geração automática do Swagger UI)
* **Utils:** [Lombok](https://projectlombok.org/) (para redução de código boilerplate)
* **Build:** [Apache Maven](https://maven.apache.org/)

## ⚙️ Como Executar (Ambiente de Desenvolvimento)

Para executar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

* [Java JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (ou superior, mas configurado para compilar em Java 17)
* [Apache Maven](https://maven.apache.org/download.cgi)
* Sua IDE favorita (ex: IntelliJ IDEA, VSCode com Java Pack)

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/jeffmmartins/digital-bank.git](https://github.com/jeffmmartins/digital-bank.git)
    cd digital-bank
    ```

2.  **Execute o projeto (via IDE):**
  * Importe o projeto como um "Existing Maven Project".
  * Certifique-se que a IDE está usando o **JDK 17** (veja `File > Project Structure` no IntelliJ).
  * Localize a classe `DigitalBankApiApplication.java` e execute-a.

3.  **Execute o projeto (via Terminal):**
    ```bash
    mvn spring-boot:run
    ```

### Acessando os Recursos

Após iniciar a aplicação, você pode acessar os seguintes serviços:

* **📄 Documentação Swagger (API):**
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

* **🗃️ Console do Banco H2:**
  [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  * **JDBC URL:** `jdbc:h2:mem:digitalbank`
  * **User Name:** `sa`
  * **Password:** (deixe em branco)


## 👨‍💻 Autor

Feito por **Jefferson Martins**.

* **GitHub:** [@jeffmmartins](https://github.com/jeffmmartins)
* **LinkedIn:** `https://www.linkedin.com/in/jefferson-martins-mendes/overlay/background-image/`



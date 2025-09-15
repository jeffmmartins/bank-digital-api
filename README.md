# Digital Bank API - Um Projeto de Estudo em Java
**Status:** Em Desenvolvimento

Este projeto é uma **API REST em Java com Spring Boot** que estou desenvolvendo ativamente como parte da minha jornada de estudos em back-end.  
O objetivo é criar um sistema para **simular um banco digital**, aplicando e consolidando conhecimentos em tecnologias e boas práticas de mercado.

A cada novo conceito ou módulo que aprendo em **Spring Framework**, **Spring Data JPA** e **desenvolvimento de APIs**, eu os implemento progressivamente neste projeto.  
Isso me permite colocar a teoria em prática imediatamente, enfrentar desafios reais de desenvolvimento e construir um **portfólio funcional**.

---

## 🚀 Tecnologias e Ferramentas Utilizadas
- **Linguagem de Programação:** Java
- **Framework:** Spring Boot (Spring Web e Spring Data JPA)
- **Banco de Dados:** H2 Database (em memória, para desenvolvimento e testes)
- **Mapeamento ORM:** JPA (via Spring Data JPA)
- **Gerenciamento de Dependências:** Maven
- **Auxiliares:** Lombok (para um código mais limpo)

---

## 🏗️ Arquitetura e Estrutura

O projeto segue a **arquitetura em camadas**, garantindo a separação de responsabilidades.

### Estrutura Atual:
- **model:**  
  Contém as classes de entidade que representam o domínio do negócio (*Cliente, Conta, Transacao*) e seus tipos (*enums*), com os relacionamentos mapeados.

- **repository:**  
  Camada de acesso a dados. As interfaces (*ClienteRepository, ContaRepository, etc.*) usam o **Spring Data JPA** para se comunicar com o banco de dados.

- **service:**  
  Camada da lógica de negócio (em construção).  
  Aqui são implementadas as regras e validações das operações financeiras (**saque, depósito, transferência, etc.**).

- **resources:**  
  Diretório de recursos que inclui o arquivo de configuração **application.yml**, definindo o comportamento do banco de dados e outras propriedades.

---

## 📌 Próximos Passos
- [ ] Finalizar a camada de serviço com a lógica de todas as operações (*saque, depósito, transferência, etc.*).
- [ ] Criar a camada de controller para expor os endpoints da API REST.
- [ ] Implementar a documentação da API com **Swagger/OpenAPI**.

---

## 👨‍💻 Sobre o Autor
Este projeto é um reflexo do meu **comprometimento em me tornar um desenvolvedor back-end Java**.  
Estou em constante evolução e **aberto a feedbacks e sugestões**.  
Sinta-se à vontade para explorar o código.  

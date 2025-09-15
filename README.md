Digital Bank API - Um Projeto de Estudo em Java
Bem-vindo(a) ao meu projeto pessoal! Este repositório é uma prova do meu aprendizado prático e da aplicação de conceitos de back-end com Java e Spring Boot. 
O objetivo é construir uma API que simula as funcionalidades essenciais de um banco digital.

O projeto está atualmente em desenvolvimento. O código reflete uma arquitetura planejada e o foco em boas práticas, como Clean Code e o uso de padrões de design.

Tecnologias e Ferramentas
Java 17+: A linguagem de programação base do projeto.

Spring Boot: Framework essencial para agilizar o desenvolvimento da API.

Spring Data JPA: Para a camada de persistência de dados.

H2 Database: Banco de dados em memória, ideal para desenvolvimento.

Lombok: Para um código mais limpo e legível.

Maven: Gerenciador de dependências.

Arquitetura e Estrutura
O projeto segue a arquitetura em camadas, garantindo a separação de responsabilidades. A estrutura atual é a seguinte:

model: Contém as classes de entidade que representam o domínio do negócio (Cliente, Conta, Transacao) e seus tipos (enums).

repository: Camada de acesso a dados. As interfaces (ClienteRepository, ContaRepository, etc.) usam o Spring Data JPA para se comunicar com o banco de dados.

service: Camada da lógica de negócio. Atualmente em construção, esta camada é onde as regras e validações das operações financeiras (como saque e depósito) são implementadas.

resources: Diretório de recursos que inclui o arquivo de configuração application.yml, definindo o comportamento do banco de dados e outras propriedades.

Próximos Passos
[ ] Finalizar a camada de serviço com a lógica de todas as operações (saque, depósito, transferência, etc.).

[ ] Criar a camada de controller para expor os endpoints da API REST.

[ ] Implementar a documentação da API com Swagger/OpenAPI.

Sobre Mim
Este projeto é um reflexo do meu comprometimento em me tornar um desenvolvedor back-end Java. Estou em constante evolução e aberto a feedbacks e sugestões. Sinta-se à vontade para explorar o código.
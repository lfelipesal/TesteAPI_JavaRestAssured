
# Teste Automatizado de API

Utilizando os conhecimentos sobre testes automatizados e de integração fui desafiado para realizar alguns testes em uma linguagem nova, com ferramentas que
não tinha conhecimento. Nesse desafio a API que foi disponibilizada para teste chama [PetStore](https://petstore.swagger.io/#/), ela está documentada de acordo
com os padrões Swagger UI.


## 🔨 Casos de teste do desafio

A API mencionada tem muitas funcionalidades, mas o que foi cobrado foram: 

- `Cadastrar um novo pedido de Pet`: Para esse caso foi consultado a documentação da API e obteve a URL pra requisição (POST /store/order) resultando em sucesso. (200)

- `Pesquisar por um pet inexistente`: Nesse caso de teste foi utilizada 2 requisições antes de fazer a pesquisa, uma para criar um novo Pet e outra para apagar.
Requisição documentada (GET /pet/{petId}) resultado em não encontrado. (404)

- `Atualizar dados de um pet existente`: Nessa caso de teste foi utilizada 1 requisições antes de atualizar algum dado do pet, uma para criar um novo Pet.
Requisição documentada (PUT /pet) resultando em sucesso. (200)

- `Pesquisar por pets com status`: O caso foi para o status de "pending" com a URL da requisição sendo (GET /pet/findByStatus) resultado esperado é sucesso. (200)

Gif abaixo mostra a IDE realizando os testes:

![Testes](https://user-images.githubusercontent.com/93229568/198815578-e878e691-183d-4abb-aad4-69c7fcbb13bc.gif)

## ✔️ Técnicas e tecnologias utilizadas

- `Java 8`: Linguagem utilizada.
- `JUnit`: Framework para teste utilizado.
- `RestAssured`: Biblioteca utilizada.
- `IntelliJ IDE`: IDE utilizada.
- `maven`: Ferramenta de automação.

## 📁 Acesso ao código do teste

O código em Java do desafio está disponível clicando [aqui](https://github.com/lfelipesal/TesteAPI_JavaRestAssured/blob/main/Test/src/test/java/casos/test/petstoreTest.java).

## 🛠️ Abrir e rodar o projeto

Para rodar os testes automatizado desse desafio é necessário a instalação da IDE IntelliJ configurada para o framework maven e JUnit,
depois de configurada é necessário clonar o repositório na maquina local e abrir o projeto na IDE seguindo o caminho que foi realizado o clone.

Depois de aberto, dentro da IDE tem o botão "run" que começa a executar o arquivo.

## 📚 Mais informações sobre a implementação

Esse desafio foi possível com base em alguns documentos sobre a utilização das ferramentas, segue abaixo algumas das referências:

- [Configuração do ambiente](https://medium.com/qa-sampa-meeting/configurando-o-ambiente-para-trabalhar-com-java-rest-assured-7b9ef802effc)
- [Utilização da biblioteca Rest Assured](https://medium.com/qa-sampa-meeting/primeiros-testes-api-rest-assured-2f4397bad355)

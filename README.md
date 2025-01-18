
# Pizza GO

Este é um projeto feito com Java Spring Boot, com a intenção de praticar meus conhecimentos na linguagem Java.

## Documentação

Para acessar os endpoints do projeto, é necessário iniciar o projeto em alguma IDE (IntelliJ, Eclipse, entre outros), e acessar pelo navegador a seguinte url:

http://localhost:8080/swagger-ui/index.html

## Conexão no Banco de Dados
Para que a API acesse o banco de dados e funcione corretamente, é necessário iniciar um banco de dados PostgreSQL localmente, e inserir as informações para a conexão com o Banco de Dados no seguinte diretório:

PizzaGo/src/main/java/resources/application.yml

É importante destacar que a API não irá funcionar caso o banco de dados não esteja ativo.

## Cadastro e Login

Para cadastrar um usuário, é necessário acessar a rota:
localhost:8080/users

após realizar o cadastro, você deverá acessar a rota:
localhost:8080/login
a partir dessa rota, você deverá indicar em um JSON o username e o password. Após fazer isso, será gerado um token, onde deverá ser inserido para fazer as requisições nas rotas /pizza.

## Enums

Alguns atributos das tabelas só aceitam valores especificos, importante que seja inseridos em UPPERCASE.

size: PEQUENO, MEDIO, GRANDE <br/>
flavor: CALABRESA, QUATRO_QUEIJOS, MARGHERITA, CHOCOLATE<br/>
categorys: SALGADO, DOCE <br/>




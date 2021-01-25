# CaseBackEnd

Para realizar o teste utilizei o spring como framework, a decisão de escolha deste framework foi somente por conhecer melhor este do que outros.
Criei um controller para receber as chamadas contendo um endpoint com o metodo post, para que a senha seja enviada pelo body da chamada.
O endpoint espera um objeto simples para o serviço:
```json
{
	"password": "AbTp9!fok"
}
```

/password/isValid , com metodo Post, será retornado um boolean informando se a validação é verdadeira ou falsa:

```json
{
	"isValid": "true"
}
```

A estrutura ficou organizada da Seguinte forma:
Config, onde realizei algumas configurações do projeto;
Controller, onde receberá as chamadas;
Service: onde criei uma classe para interceptar a implementação da lógica para a Controller;
ServiceImpl: onde criei uma classe para a implementação da lógica;
Model: onde criei as classes de Objetos de acordo com as regras;

Para realizar os testes utilizei as ferramentas JUnit e MockMVC para os testes no model Movie e nos testes dos endpoints da controller.
Realizei a criação dos testes de acordo com as regras e especificações do desafio

Também realizei a configuração do Swagger para documentação da API.
Então poderá utilizar o link http://localhost:8080/swagger-ui.html para acessar a documentção do projeto na opção filme-controller.

*Execução*
Para a basta seguir os dois camandos abaixo na pasta do projeto, necessário ter as variaeis de ambiente do Maven e do Java para executar:
1º:
mvn clean install

2º:
java -jar target/password-0.0.1-SNAPSHOT.jar

*Extra*
Realizei também a configuração de um ambiente ElasticBeanstalk na minha conta da AWS com o seguinte link:
http://donus-env.us-east-1.elasticbeanstalk.com/
Deixarei disponível até o fim do processo caso queriam utilizar está disponível 
Swagger:
http://donus-env.us-east-1.elasticbeanstalk.com/swagger-ui.html


Desde de já agradeço a oportunidade e mesmo que não seja selecionado para avançar gostaria de receber o feedback para eu melhorar no meu desenvolvimento!

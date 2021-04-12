TinyURL !

Como testar: 

Tenha o admin do PostgreSQL rodando na máquina na mesma porta que a da configuração no arquivo application.properties

Quando o server estiver rodando na mesma porta 5432

Importar o projeto no IntelliJ, buildar e se possível usar o Postman para fazer as requisições:

Faça uma requisição POST localhost:8080/ com body alias e url

Ex:
{
    "alias": "google",
    "url": "https://www.google.com"
}

Depois faça uma requisição GET localhost:8080/google e verá que o response é a página da URL que foi digitada, por exemplo, a página da Google.

Vá até o admin PostgreSQL e rode o comando:
SELECT * FROM REDIRECT

Ele deverá retornar a url e alias que foram executados.


1	"google"	"https://www.google.com"
2	"aaaaa"	        "https://www.google.com"


Frontend em construção.

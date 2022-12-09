# kyrosb-02 

Projeto desenvolvido para um processo seletivo na Kyros. Enjoy!

## Tecnólogias

+ Java 11
+ Spring Framework (MVC,Data)
+ Hibernate
+ Hibernate Validation
+ H2 database
+ JUnit
+ Maven
+ Angular 12
+ NGZorro
+ Bootstrap 5

## Pré requisito

+ Node js
+ Angular Cli
+ Java 11
+ Servidor de aplicação para .war

## Instalação

###### Backend
1. Entre no pasta **backend**
2. Insira o command **mvn clean package**
3. Na pasta target, será gerado o .war da aplicação
4. Configure em seu servidor

###### Frontend
1. Entre no pasta **frontend**
2. Insira o command **ng build**
3. Na pasta dis, será gerado os arquivos bundles da aplicação
4. Configure em seu servidor

**Documentação**

#### Backend

**Cadastro Cliente**

> POST http://localhost:8080/kyros/cliente/criar

Modelo de JSON para pessoa física:
```
{

	"nome": "Nome",

	"dataNascimento": "2022-01-01",

	"endereco": "Rua 1",

        "cpf": "15001565740"

}
```

Modelo de JSON para pessoa jurídica:
```
{

	"nome": "Nome",

	"dataNascimento": "2022-01-01",

	"endereco": "Rua 1",

        "cnpj": "61719371000112"

}
```
**Alterar Cliente**

> PUT http://localhost:8080/kyros/cliente/alterar

Modelo de JSON para pessoa física:
```
{
        "id": 0,
  
	"nome": "Nome",

	"dataNascimento": "2022-01-01",

	"endereco": "Rua 1",

        "cpf": "15001565740"

}
```

Modelo de JSON para pessoa jurídica:
```
{
        "id": 0
  
	"nome": "Nome",

	"dataNascimento": "2022-01-01",

	"endereco": "Rua 1",

        "cnpj": "61719371000112"

}
```
**Listar Cliente**

> GET http://localhost:8080/kyros/cliente/listar

**excluir Cliente**

> DELETE http://localhost:8080/kyros/cliente/excluir/{id}

**Cadastro Produto**

> POST http://localhost:8080/kyros/produto/criar

Modelo de JSON :
```
{
  
	"nome": "PRODUTO",
  
        "descricao": "DESCRICAO",

	"valorUnidade": 10.0,

         "status": "ATIVO"

}
```
**Alterar Produto**

> PUT http://localhost:8080/kyros/produto/alterar

Modelo de JSON :
```
{
        "id":0
  
	"nome": "PRODUTO",
  
        "descricao": "DESCRICAO",

	"valorUnidade": 10.0,

        "status": "ATIVO"

}

```
**Listar Produto**

> GET http://localhost:8080/kyros/produto/listar

**Excluir Produto**

> DELETE http://localhost:8080/kyros/produto/excluir/{id}

**Cadastro Lançamento**

> POST http://localhost:8080/kyros/lancamento/criar

Modelo de JSON :
```
{
  
  "clienteId": 0,
  
  "produtoId": 0,
  
  "quantidadeVendida": 10.0,

  "valorTotal": 10.0,

  "dataVenda": "2022-01-01"

}
```

**Alterar Lançamento**

> PUT http://localhost:8080/kyros/lancamento/alterar

Modelo de JSON :
```
{
  "id": 0,
  
  "clienteId": 0,
  
  "produtoId": 0,
  
  "quantidadeVendida": 10.0,

  "valorTotal": 10.0,

  "dataVenda": "2022-01-01"

}
```

**Listar Lançamento**

> GET http://localhost:8080/kyros/lancamento/listar

**Excluir Lançamento**

> DELETE http://localhost:8080/kyros/lancamento/excluir/{id}


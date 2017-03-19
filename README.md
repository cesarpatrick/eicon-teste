# eicon-teste
Teste de seleção

# Configuração do Banco de Dados
-Executar script do diretorio: teste\src\main\resources\scripts\teste-eicon.sql

-Abrir a Classe TesteApplication.java

-Alterar os dados abaixo de acordo com seu banco de dados

    dataSource.setUrl("jdbc:mysql://localhost:3306/eicon"); //Informações do banco/schema
    
    dataSource.setUsername("root");//Usuario
    
    dataSource.setPassword("Cesar33775644");//Senha

# Urls Formato Json

-Cadastro de pedidos
http://localhost:8080/teste/api/service/json/pedido

-Listar todos pedidos
http://localhost:8080/teste/api/service/json/listPedido

-Buscar pedido pelo numero de controle
http://localhost:8080/teste/api/service/json/pedido/1
(Após a última barra o numero de controle desejado.)

-Buscar pedidos pela data
http://localhost:8080/teste/api/service/json/pedido/data/19-03-2017
(Após a última barra a data desejada no formato dd-MM-yyyy)

Exemplo arquivo Json:

{"pedido":
	[{
      "numeroControle": 50,
      "data": "19/03/2017",
      "nome": "Carne",
      "valor": 10,
      "quantidade": 5,
      "codigoCliente": 1
    },
	{
      "numeroControle": 51,
      "data": "17/03/2017",
      "nome": "Farofa",
      "valor": 100,
      "quantidade": 11,
      "codigoCliente": 1
    }]
}

# Urls Formato XML

-Cadastro de pedidos
http://localhost:8080/teste/api/service/xml/pedido

-Listar todos pedidos
http://localhost:8080/teste/api/service/xml/listPedido

-Buscar pedido pelo numero de controle
http://localhost:8080/teste/api/service/xml/pedido/1
(Após a última barra o numero de controle desejado.)

-Buscar pedidos pela data
http://localhost:8080/teste/api/service/xml/pedido/data/19-03-2017
(Após a última barra a data desejada no formato dd-MM-yyyy)

Exemplo arquivo XML:
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<pedidos>
    <pedido>
        <codigoCliente>1</codigoCliente>
        <data>17/03/2017</data>
        <nome>Farofa</nome>
        <numeroControle>54</numeroControle>
        <quantidade>11</quantidade>
        <valor>100.0</valor>
        <valorTotal>990.0</valorTotal>
    </pedido>
</pedidos>

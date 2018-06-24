# eicon-teste (Rest Service)

# Database Panel
-Execute directory script: test \ src \ main \ resources \ scripts \ test-eicon.sql

-Open the TestApplication.java Class

-change the data below according to the database

    dataSource.setUrl("jdbc:mysql://localhost:3306/eicon"); //database information/schema
    
    dataSource.setUsername("root");//User
    
    dataSource.setPassword("Cesar33775644");//Password

# Urls Json Formatt

-Ordem form
http://localhost:8080/teste/api/service/json/pedido

-List all orders
http://localhost:8080/teste/api/service/json/listPedido

-Searching a order by your number control
http://localhost:8080/teste/api/service/json/pedido/1
(After the last `/` put the number control)

-Searching a order by date
http://localhost:8080/teste/api/service/json/pedido/data/19-03-2017
(After the last `/` put in this formatt dd-MM-yyyy)

Exemple Json Archive:

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

# Urls XML Formatt

-Ordem form
http://localhost:8080/teste/api/service/xml/pedido

-List all orders
http://localhost:8080/teste/api/service/xml/listPedido

-Searching a order by your number control
http://localhost:8080/teste/api/service/xml/pedido/1
(After the last `/` put the number control)

-Searching a order by date
http://localhost:8080/teste/api/service/xml/pedido/data/19-03-2017
(After the last `/` put in this formatt dd-MM-yyyy)

Exemple XML Archive:


<?xml version="1.0" encoding="UTF-8" standalone="yes"?>

<pedidos>
	
    <pedidos>
	    <pedido>    
		<codigoCliente>1</codigoCliente>
		<data>17/03/2017</data>
		<nome>Farofa</nome>
		<numeroControle>84</numeroControle>
		<quantidade>11</quantidade>
		<valor>100.0</valor>	
	    </pedido>
    </pedidos>
    
</pedidos>


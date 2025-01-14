
## Dependencias
Java 21

Tendo maven instalado via linha de commando
```shell
./mvn spring-boot:run
```

Swagger
http://localhost:8090/swagger-ui/index.html

-----
H2 Database

http://localhost:8090/h2-console

H2-URL: h2:mem:testdb

username: sa

password: password

----
Depois com alguma aplicação de chamada de API

Validações:

* Caso 1 - cadastro de automoveis
```shell
curl --location 'http://localhost:8090/api/veiculos/cadastroAutomoveis' \
--header 'Content-Type: application/json' \
--data '{
        "marca": "Honda",
        "modelo": "Civic",
        "valor": 50000.00,
        "dataCadastro": "2025-01-15"
}'
```

```shell
curl --location 'http://localhost:8090/api/veiculos/cadastroAutomoveis' \
--header 'Content-Type: application/json' \
--data '{
        "marca": "Toyota",
        "modelo": "Corolla",
        "valor": 80000.00,
        "dataCadastro": "2025-01-15"
}'
```

* Caso 2 - lista um automovel
```shell
curl --location 'http://localhost:8090/api/veiculos/automovel/2'
```

* Caso 3 - lista todos os automoveis
```shell
curl --location --request GET 'http://localhost:8090/api/veiculos/automoveis' \
--header 'Content-Type: application/json' \
--data '{
    
}'
```

Tests realizados:

![Screenshot from 2025-01-13 23-58-23.png](../../../../Pictures/Screenshots/Screenshot%20from%202025-01-13%2023-58-23.png)
![Screenshot from 2025-01-13 23-57-48.png](../../../../Pictures/Screenshots/Screenshot%20from%202025-01-13%2023-57-48.png)
![Screenshot from 2025-01-13 23-56-53.png](../../../../Pictures/Screenshots/Screenshot%20from%202025-01-13%2023-56-53.png)
![Screenshot from 2025-01-13 23-54-42.png](../../../../Pictures/Screenshots/Screenshot%20from%202025-01-13%2023-54-42.png)
![Screenshot from 2025-01-13 23-54-29.png](../../../../Pictures/Screenshots/Screenshot%20from%202025-01-13%2023-54-29.png)
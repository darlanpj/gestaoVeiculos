
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
![Screenshot from 2025-01-13 23-54-29](https://github.com/user-attachments/assets/1d09d637-638f-4233-b22c-59282b3a12ca)
![Screenshot from 2025-01-13 23-54-42](https://github.com/user-attachments/assets/4645901b-b2b7-495e-be6e-f0a648336d40)
![Screenshot from 2025-01-13 23-56-53](https://github.com/user-attachments/assets/289e5709-79f9-4b5a-84ea-a1b2046c164e)
![Screenshot from 2025-01-13 23-57-48](https://github.com/user-attachments/assets/ca7d9033-a2b7-45ff-bd7a-6ecab128e80e)
![Screenshot from 2025-01-13 23-58-23](https://github.com/user-attachments/assets/9d925abc-31b9-4c61-84d6-999aabca35f0)


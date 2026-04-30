# Projeto DimDim PCs

## Descrição
Aplicação de API REST para gerenciamento de venda de PCs, desenvolvida com Spring Boot.  
O sistema permite operações CRUD para Produtos, Clientes, Estoques e Pedidos.

Este projeto foi desenvolvido para o CP2 da disciplina de DevOps, utilizando Docker e Azure.

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- Azure VM

---

## Arquitetura

A aplicação é composta por dois containers Docker:

- Banco de dados: `mysql-dimdim-rm562156`
- Aplicação Spring Boot: `spring-app-rm562156`

Ambos os containers estão conectados através da rede Docker:
`dimdim-network`

---

## Requisitos atendidos

✔ Container de banco de dados  
✔ Volume nomeado para persistência  
✔ Containers com portas expostas  
✔ Uso de variáveis de ambiente  
✔ Containers em execução em segundo plano  
✔ Nome dos containers contendo RM  

---

## Banco de Dados

- SGBD: MySQL 8
- Banco: `dimdim`

Tabelas criadas automaticamente pelo Hibernate:

- produto
- cliente
- estoque
- pedido

---

## Endpoints da API

### Produtos

- GET `/produtos`
- POST `/produtos`
- PUT `/produtos/{id}`
- DELETE `/produtos/{id}`

---

### Clientes

- GET `/clientes`
- POST `/clientes`
- PUT `/clientes/{id}`
- DELETE `/clientes/{id}`

---

### Estoques

- GET `/estoques`
- POST `/estoques`
- PUT `/estoques/{id}`
- DELETE `/estoques/{id}`

---

### Pedidos

- GET `/pedidos`
- POST `/pedidos`
- PUT `/pedidos/{id}`
- DELETE `/pedidos/{id}`

---

## Execução do Projeto

### 1. Criar rede Docker
docker network create dimdim-network

---

### 2. Criar volume
docker volume create mysql-data

---

### 3. Subir container do MySQL
docker run -d \
--name mysql-dimdim-rm562156 \
--network dimdim-network \
--restart always \ 
-e MYSQL_ROOT_PASSWORD=root \
-e MYSQL_DATABASE=dimdim \
-v mysql-data:/var/lib/mysql \
-p 3306:3306 \
mysql:8.0

---

### 4. Gerar o JAR
mvn clean package -DskipTests


---

### 5. Rodar aplicação Spring Boot
docker run -d
--name spring-app-rm562156 \
--network dimdim-network \
-p 8080:8080 \
-v "$(pwd)/target/dimdim-pcs-0.0.1-SNAPSHOT.jar:/app/app.jar" \
eclipse-temurin:21-jdk \
java -jar /app/app.jar

---

## Testes

A API pode ser testada via Postman ou curl:

Exemplo:
GET http://IP_DA_VM:8080/produtos

---

## Autor

Pedro Henrique dos Santos Costa  
RM 562156

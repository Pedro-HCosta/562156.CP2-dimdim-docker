# Comandos Docker - Projeto DimDim PCs

## Criar rede Docker

docker network create dimdim-network

---

## Criar volume nomeado

docker volume create mysql-data

---

## Subir container MySQL

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

## Gerar o JAR da aplicação

mvn clean package -DskipTests

---

## Rodar aplicação Spring Boot

docker run -d \
--name spring-app-rm562156 \
--network dimdim-network \
-p 8080:8080 \
-v "$(pwd)/target/dimdim-pcs-0.0.1-SNAPSHOT.jar:/app/app.jar" \
eclipse-temurin:21-jdk \
java -jar /app/app.jar

---

## Verificar containers

docker ps

---

## Verificar imagens

docker image ls

---

## Verificar volumes

docker volume ls

---

## Verificar redes

docker network ls

# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-alpine

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR da aplicação para o container
COPY target/auth-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação Spring Boot usa (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
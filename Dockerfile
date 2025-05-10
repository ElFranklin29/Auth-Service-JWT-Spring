FROM eclipse-temurin:17 AS builder
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests


FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
#FROM openjdk:11
#LABEL maintainer="goodluck.net"
#WORKDIR /app
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#RUN ./mvnw dependency:go-offline
#COPY src ./src
#CMD ["./mvnw", "docker-test:run"]
FROM openjdk:11
LABEL maintainer="goodluck.net"
ADD target/demo_product-0.0.1-SNAPSHOT.jar demo_product.jar
ENTRYPOINT ["java" , "-jar", "demo_product.jar" ]
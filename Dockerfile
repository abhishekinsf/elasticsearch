FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

Maintainer Abhishek

COPY pom.xml /build/
COPY  src /build/src/

WORKDIR /build/

RUN mvn package

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/docker-elastic-search-boot.jar /app/

ENTRYPOINT ["java", "-jar", "docker-elastic-search-boot.jar"]
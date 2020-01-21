FROM alpine/git
WORKDIR /test
RUN git clone https://github.com/abhishekinsf/elasticsearch.git

FROM maven:3.5.2-jdk-8-alpine

WORKDIR /test

COPY --from=0 /test/elasticsearch /test

RUN ["mvn", "package", "-DskipTests=true"]

FROM openjdk:8-jre-alpine

WORKDIR /test

COPY --from=1 /test/target/*.jar /test

EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar *.jar"]  



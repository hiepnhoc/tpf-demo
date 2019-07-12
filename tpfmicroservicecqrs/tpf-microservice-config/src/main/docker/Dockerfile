FROM openjdk:8-jre-slim
VOLUME /tmp
EXPOSE 8888
ADD tpf-microservice-config-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
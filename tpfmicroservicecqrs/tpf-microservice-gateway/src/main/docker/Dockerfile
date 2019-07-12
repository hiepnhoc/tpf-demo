FROM openjdk:8-jre-slim
VOLUME /tmp
EXPOSE 8765
ADD tpf-microservice-gateway-0.0.1-SNAPSHOT.jar app.jar
ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
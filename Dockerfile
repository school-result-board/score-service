FROM openjdk:8-jre-alpine
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ENV spring.profiles.active=test
ENV server.port=80
ADD ./bootstrap/build/libs/bootstrap-0.0.1-SNAPSHOT.jar score-service.jar

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar score-service.jar

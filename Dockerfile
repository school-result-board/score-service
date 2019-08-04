FROM openjdk:8-jre-alpine
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ENV server.port=9000
ENV spring.profiles.active=test
ADD ./bootstrap/build/libs/bootstrap-0.0.1-SNAPSHOT.jar score-service.jar
EXPOSE 9000
# ENTRYPOINT exec java $JAVA_OPTS -jar school-result-board.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar score-service.jar

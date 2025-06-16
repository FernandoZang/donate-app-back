FROM openjdk:17-jdk-slim

WORKDIR /donation

ENV banco.password="donation123*"
ENV banco.username="donation-app"

RUN adduser appuser
RUN chmod +x -R /donation
RUN chown -R appuser /donation
USER appuser

COPY /build/libs/*.jar ./app.jar

EXPOSE 8080 3306 33060

ENTRYPOINT [ "java", "-D$JAVA_OPTS", "-jar", "app.jar" ]
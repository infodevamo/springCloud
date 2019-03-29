FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/proxy.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/proxy.jar"]

EXPOSE 8081

FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/members-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/members-service.jar"]

EXPOSE 2222

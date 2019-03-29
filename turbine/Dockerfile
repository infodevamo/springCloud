FROM openjdk:8-jre-alpine
MAINTAINER David THIBAU <david.thibau@gmail.com>

ADD ./target/turbine.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/turbine.jar"]

EXPOSE 5555

FROM maven AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM tomcat:8.0.20-jre8

EXPOSE 8080

COPY --from=build target/maven-web-app.war /usr/local/tomcat/webapps/maven-web-app.war

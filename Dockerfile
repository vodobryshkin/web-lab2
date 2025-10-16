FROM tomcat:10-jdk21-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY app.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]

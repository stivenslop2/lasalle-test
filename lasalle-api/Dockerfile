FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
RUN  apt -y update
RUN apt -y install ttf-mscorefonts-installer fontconfig binutils-x86-64-linux-gnu libbinutils systemd dbus binutils-common telnet  iputils-ping
RUN fc-cache -f -v
ENV PORT 8080
EXPOSE 8080




COPY target/*.jar /opt/
WORKDIR /opt
ENTRYPOINT exec java $JAVA_OPTS -jar fresnillo-db-api-1.0.jar

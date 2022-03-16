# La Salle API
La Salle API Prueba Técnica


## Demo

Actualmente corre un demo en un servidor en la nube con la siguientes caracteristicas:

- [Endpoint API](http://34.201.6.83:5005/)
- [Swagger Docs](http://34.201.6.83:5005/)

## Requisitos

Para construir y levantar la aplicación tu necesitas:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Levantar aplicación localmente


Ubicar la raiz de la API y ejecutar los siguientes comandos:
- mvn install - "Para instalar dependencias"
- mvn clean package - "Para empaquetar el proyecto en un Jar"

Dirigirse a la carpeta "/target" y ejecutar el siguiente comando: 
- java -jar lasalle-api-1.0.jar - "Para levantar el proyecto"

La API se levantara en un servidor tomcat con el puerto 5005



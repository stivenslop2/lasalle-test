# API Fresnillo Reing
Demo

### Prerequisitos
Demo

### Manejo del repositorio

Para realizar **commits** al repositorio se utilizará el siguiente formato[2](#refSemanticCommit):

```
<tipo commit>(<alcance>): <asunto>
```

Los **tipos** de commit son:

- **Caracteristica**: Una nueva caracteristica para el usuario, no una nueva caracteristica para los scripts de construcción o compilación
- **Arreglo**: Arreglo de un fallo para el usuario, de los scripts de construcción o compilación
- **Documentación**: Cambios a la documentación
- **Estilo**: Cambios de estilo, punto y comas faltantes, etc, no los cambios del código de producción
- **Refactorización**: Refactorización del código, como el cambio de nombre de una variable
- **Prueba**: Agregar pruebas faltantes, refactorización de pruebas, no los cambios del código de producción
- **Rutina**: Actualización de los scripts de automatización, contrucción o compilación, no los cambios del código de producción

El **Alcance** se incluye en el commit para agregar información, en caso de omitirse, los paréntesis también se deben omitir.

El **Asunto** del commit se debe hacer de modo imperativo, en tiempo presente, por ejemplo "cambiar", no "cambios" ni "cambiado" e incluye la motivación por la cual se realizó el cambio, contrastando con el estado anterior

#### EJEMPLO

`Caracteristica: Agregar pantalla de preguntas y respuestas`

#SUBIR IMAGEN AL REPOSITORIO DE GIT

# example-runtime-bundle

Example API
This repository contains an Example API used by the Activiti Cloud Examples.

api
Crear imagen: docker build . --tag api:0.2
Apunta imagen a Docker: docker tag IMG_ID iikt/fresnillo-api:0.2
Subir imagen a Repo iikt: docker push iikt/fresnillo-api:0.2
mvn clean install -DskipTests
docker build -t  luisbarrera/fresnillo-db .
docker push luisbarrera/fresnillo-db




api
Crear imagen: docker build . --tag iikt/fresnillo-db:0.1
Apunta imagen a Docker: docker tag IMG_ID iikt/fresnillo-db:0.1
Subir imagen a Repo iikt: docker push iikt/fresnillo-db:0.1

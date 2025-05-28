# Java Docker

Applicazione java statica containerizzata composta da:
- Backend Spring Boot con 3 estensioni (Spring Data JPA, MySQL Driver, Spring Web) con endpoint REST (`/greetings`)
- Frontend HTML statico servito da Nginx
- Entrambi i componenti sono containerizzati tramite Docker
- Coordinamento con Docker Compose

# Struttura del progetto
├── FE/
│ ├── index.html
│ └── DockerfileFE
├── src/
│ └── main/.../config && controller
├── pom.xml
├── dockerFile
├── docker-compose.yml

# OBBIETTIVO
È abilitato per accettare richieste da qualsiasi origine, utile per comunicare con il frontend:
registry.addMapping("/**")
.allowedOrigins("*")
.allowedMethods("GET", "POST", "PUT", "DELETE")
.allowCredentials(false);

# Containerizzazione
Abbiammo creato 2 container 1 per Il BackEnd e 1 per Il FrontEnd, Questa separazione consente di gestire indipendentemente le due parti dell’applicazione, facilitando sviluppo, test e deploy.
Il backend è costruito partendo da un'immagine Maven per la build e un’immagine OpenJDK per l’esecuzione, mentre il frontend sfrutta un'immagine Nginx standard per servire i file statici.
Per coordinare i container abbiamo usato Docker Compose, che avvia e collega automaticamente frontend e backend.

Comandi che abbiamo fatto:
docker build -t backend-app .
docker run -d -p 8080:8080 backend-app // Ora il backend è raggiungibile su http://localhost:8080.

docker build -t frontend-app -f DockerfileFE .
docker run -d -p 8081:80 frontend-app  // Il frontend è raggiungibile su http://localhost:8081.

Docker Compose
docker-compose up --build // Questo comando: costruisce automaticamente entrambe le immagini (backend e frontend) usando i rispettivi Dockerfile e avvia i container con le porte e dipendenze configurate

Per fermare tutto:
docker-compose down

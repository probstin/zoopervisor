# Zoopervisor

A Zoo management application built with Spring Boot and Angular.

## Quick Start

- `git clone git@github.com:probstin/zoopervisor.git && cd zoopervisor`
- `mv api/.env.EXAMPLE api/.env`
- Add the `EXCHANGE_API_KEY` & `EXCHANGE_API_URL` values to the `./api/.env` file
- `docker compose up`

## :whale: Docker

To run in concert, as an application:

`docker compose up`

To run the services individually:

```bash
# build
docker build -t probstin09/zoopervisor-api ./api
# run
docker run -p 8080:8080 probstin09/zoopervisor-api
# publish (to the probstin09 DockerHub repo)
docker push probstin09/zoopervisor-api:latest
```

```bash
# build
docker build -t probstin09/zoopervisor-client ./client
# run
docker run -p 4200:4200 probstin09/zoopervisor-client
# publish (to the probstin09 DockerHub repo)
docker push probstin09/zoopervisor-client:latest
```
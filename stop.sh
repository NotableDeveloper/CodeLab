#! /bin/bash
cd docker
docker compose down
docker rmi docker-msg_broker
docker rmi docker-codelab
docker rmi docker-maria_db
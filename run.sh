#!/usr/bin/env bash

./gradlew clean
./gradlew bootJar
chmod 755 ./build/libs/*.jar
cp ./build/libs/*.jar ./docker/app.jar
cd docker
docker compose up -d
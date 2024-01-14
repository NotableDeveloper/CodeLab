#! /bin/bash
sed -i 's/\r//' ./docker/create_db.sh

cd codelab_app/
sed -i 's/\r//' gradlew
./gradlew clean
./gradlew bootJar
chmod 755 ./build/libs/*.jar
cp ./build/libs/*.jar ../docker/app.jar

cd ../message_broker
sed -i 's/\r//' gradlew
./gradlew clean
./gradlew bootJar
chmod 755 ./build/libs/*.jar
cp ./build/libs/*.jar ../docker/msg_broker.jar

cd ../docker
docker compose up -d
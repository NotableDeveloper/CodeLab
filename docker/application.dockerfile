FROM gradle:8.4-jdk-alpine
COPY app.jar ./app.jar
CMD sleep 5 && java -jar app.jar
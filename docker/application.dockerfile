FROM gradle:8.4-jdk-alpine
COPY app.jar ./app.jar
CMD java -jar app.jar
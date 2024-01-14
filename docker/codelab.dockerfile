FROM amazoncorretto:17
COPY app.jar ./app.jar
CMD sleep 5 && java -jar app.jar
FROM gradle:8.4-jdk-alpine
COPY msg_broker.jar ./msg_broker.jar
CMD sleep 5 && java -jar msg_broker.jar
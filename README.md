# Quarkus Demo : Kafka + REST Client

This project demonstrates how to call a REST service for each message received from Kafka and send the result from the service to another Kafka topic.

## Run the demo

1. Start the Kafka Broker
```bash
docker-compose up -d
```
2. Run the application:
```bash
mvn quarkus:dev
```
3. Send new transactions (requires httpie):
```bash
http ":8080/demo?name=MacroHard&amount=20"
http ":8080/demo?name=BlueHat&amount=10"
```
4. Use any Kafka viewer such as Kafka Tools to see the written records

## Cleanup 

```bash
docker-compose down
docker-compose rm
```
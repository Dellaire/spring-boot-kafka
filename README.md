# spring-boot-kafka

This is just a sandbox for playing around with Apache Kafka via Spring Boot.

## Setting up the required Infrastructure

The infrastructure needed to run this application can be set up by calling `docker-compose up` from root directory of this repository.

## Kafka Configuration

Configurations can be done via the Confluent Control Center. It is accessible under http://localhost:9021.

### Reading Data from RabbitMQ

Kafka Connect can access a RabbitMQ queue by using a configuration like this:

```
{
  "name": "RabbitmqConnector",
  "connector.class": "io.confluent.connect.rabbitmq.RabbitMQSourceConnector",
  "rabbitmq.host": "rabbitmq",
  "rabbitmq.username": "guest",
  "rabbitmq.password": "guest",
  "rabbitmq.virtual.host": "/",
  "rabbitmq.port": "5672",
  "kafka.topic": "resourceAccess",
  "rabbitmq.queue": [
    "resourceAccess"
  ]
}
```

## Useful Information

* https://www.confluent.io/blog/apache-kafka-spring-boot-application/
* https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html
* https://rmoff.net/2018/08/02/kafka-listeners-explained/
* https://medium.com/trendyol-tech/how-to-implement-retry-logic-with-spring-kafka-710b51501ce2
* https://github.com/confluentinc/demo-scene/tree/master/rabbitmq-into-kafka

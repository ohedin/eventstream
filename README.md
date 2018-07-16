# eventstream

Use of KSQL to create an event streaming example with kafka.

## How to run ?

### Pre-requisites

 * Have a kubernetes cluster running and kubectl connected to it
 * Install [kubetail](https://github.com/johanhaleby/kubetail)

### Start the infra

This step will create the namespace "eventstream" in your k8s cluster and deploy the following components :
 * zookeeper (needed for kafka)
 * kafka
 * schema registry (needed for KSQL)
 * ksql server

```bash
cd dev
sh ./start-infra.sh
```

### Create the kafka topic

This step will create the kafka topic PAGE_VISITS.

```bash
cd dev
sh ./create-topics.sh
```

### (Optional) Have a listener on the kafka topic

This step will create a kafka-console-consumer on the topic PAGE_VISITS.

```bash
cd dev
sh ./consume-topic.sh
```

Then you can send some messages in the topic to check if it works as expected

In another shell :
```bash
cd dev
sh ./produce-in-topic.sh
```

You should see the message displayed in the shell in which you have your consumer.

### (Optional) Play with KSQL Cli

This step will create a KSQL command line client and give you the prompt in it.

```bash
cd dev
sh ./run-ksql-cli.sh
```

Then you can type :

```
CREATE STREAM PAGE_VISITS (time bigint, site varchar, ip varchar) WITH (kafka_topic='PAGE_VISITS', value_format='json');
SELECT time, site, ip FROM PAGE_VISITS;
```

The query is now running.

In another shell, produce some messages in the topic :

```bash
cd dev
sh ./produce-in-topic.sh
```

You should see the records in the KSQL Cli.

### Stop the infra

This step will shutdown and remove the existing infra deployed in the namespace eventstream.

```bash
cd dev
sh ./stop-infra.sh
```

### Architecture


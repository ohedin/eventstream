#!/usr/bin/env bash

echo "Creating topic ..."
kubectl run -i --tty create-topic \
    --image=confluentinc/cp-kafka:4.1.1 \
    --namespace=eventstream \
    --restart=Never \
    --rm=True \
    --command -- kafka-topics \
        --create \
        --topic PAGE_VISITS \
        --partitions 1 \
        --replication-factor 1 \
        --if-not-exists \
        --zookeeper zookeeper:32181

echo "Topic list :"
kubectl run -i --tty list-topics \
    --image=confluentinc/cp-kafka:4.1.1 \
    --namespace=eventstream \
    --restart=Never \
    --rm=True \
    --command -- kafka-topics \
        --list \
        --zookeeper zookeeper:32181

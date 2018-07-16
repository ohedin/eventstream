#!/usr/bin/env bash

echo "Describe topic ..."
kubectl run -i --tty describe-topic \
    --image=confluentinc/cp-kafka:4.1.1 \
    --namespace=eventstream \
    --restart=Never \
    --rm=True \
    --command -- kafka-topics \
        --describe \
        --topic PAGE_VISITS \
        --zookeeper zookeeper:32181

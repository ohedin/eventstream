#!/usr/bin/env bash

echo "Produce in topic ..."
cat msg/page_visits.txt | kubectl run -i produce-in-topic \
    --image=confluentinc/cp-kafka:4.1.1 \
    --namespace=eventstream \
    --restart=Never --rm=True \
    --command -- kafka-console-producer \
        --topic PAGE_VISITS \
        --broker-list kafka:9092 \
        --property "parse.key=true" \
        --property "key.separator=&"


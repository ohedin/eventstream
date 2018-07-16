#!/usr/bin/env bash

echo "Consume topic ..."
kubectl run -i --tty consume-topic \
    --image=confluentinc/cp-kafka:4.1.1 \
    --namespace=eventstream \
    --restart=Never \
    --rm=True \
    --command -- kafka-console-consumer \
        --topic PAGE_VISITS \
        --bootstrap-server kafka:9092 \
        --from-beginning

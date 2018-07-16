#!/usr/bin/env bash

kubectl run -i --tty ksql-cli \
    --image=confluentinc/cp-ksql-cli:5.0.0-beta180702222458 \
    --namespace=eventstream \
    --restart=Never \
    --rm=True \
    --command -- ksql http://ksql-server:8088
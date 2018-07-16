#!/usr/bin/env bash

kubectl apply -f infra/namespace.yaml

kubectl apply -f infra/zookeeper.yaml
kubectl apply -f infra/kafka.yaml
kubectl apply -f infra/schema-registry.yaml
kubectl apply -f infra/ksql-server.yaml

sleep 5

kubetail --namespace eventstream
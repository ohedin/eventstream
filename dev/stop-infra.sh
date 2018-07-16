#!/usr/bin/env bash

kubectl delete -f infra/ksql-server.yaml
kubectl delete -f infra/schema-registry.yaml
kubectl delete -f infra/kafka.yaml
kubectl delete -f infra/zookeeper.yaml

kubectl delete -f infra/namespace.yaml

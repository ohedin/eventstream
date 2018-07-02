#load("@io_bazel_rules_docker//java:image.bzl", "java_image")

java_library(
    name = "producer",
    srcs = glob(["src/main/java/producer/MyProducer.java"]),
    deps = [
        "@org_apache_kafka_kafka_clients//jar",
        "@org_apache_avro_avro//jar",
        "@io_confluent_kafka_avro_serializer//jar",
    ],
    visibility = ["//visibility:public"],
)

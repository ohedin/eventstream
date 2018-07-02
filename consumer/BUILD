#load("@io_bazel_rules_docker//java:image.bzl", "java_image")

java_library(
    name = "consumer",
    srcs = glob(["src/main/java/consumer/MyKSQLConsumer.java"]),
    deps = [
        "@org_apache_kafka_kafka_clients//jar",
        "@org_apache_avro_avro//jar",
        "@io_confluent_kafka_avro_serializer//jar",
        "@io_confluent_ksql_ksql_engine//jar",
        "@io_confluent_ksql_ksql_common//jar",
        "@io_confluent_ksql_ksql_parser//jar",
        "@org_apache_kafka_kafka_streams//jar",
        "@io_confluent_ksql_ksql_metastore//jar",
        "@io_confluent_ksql_ksql_serde//jar",
        "@org_apache_kafka_connect_api//jar",
        "@com_google_guava_guava//jar",
        "@org_antlr_antlr4_runtime//jar",
        "@io_airlift_slice//jar",
        "@org_openjdk_jol_jol_core//jar",
        "@org_codehaus_janino_janino//jar",
        "@org_codehaus_janino_commons_compiler//jar",
    ],
    visibility = ["//visibility:public"],
)

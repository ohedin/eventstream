load("@bazel_gazelle//:def.bzl", "gazelle")

gazelle(
    name = "gazelle",
    prefix = "github.com/ohedin/eventstream",
)

load("@io_bazel_rules_docker//java:image.bzl", "java_image")

java_image(
    name = "eventstream-producer",
    main_class = "producer.MyProducer",
    runtime_deps = [
        "//producer:producer",
        "@io_confluent_common_config//jar",
        "@org_slf4j_slf4j_api//jar",
        "@io_confluent_kafka_schema_registry_client//jar",
        "@io_confluent_common_utils//jar",
        "@com_fasterxml_jackson_core_jackson_databind//jar",
        "@com_fasterxml_jackson_core_jackson_annotations//jar",
        "@com_fasterxml_jackson_core_jackson_core//jar",
        "@org_codehaus_jackson_jackson_core_asl//jar",
        "@org_codehaus_jackson_jackson_mapper_asl//jar",
    ],
)

java_image(
    name = "eventstream-consumer",
    main_class = "consumer.MyKSQLConsumer",
    runtime_deps = [
        "//consumer:consumer",
        "@io_confluent_common_config//jar",
        "@org_slf4j_slf4j_api//jar",
        "@io_confluent_kafka_schema_registry_client//jar",
        "@io_confluent_common_utils//jar",
        "@com_fasterxml_jackson_core_jackson_databind//jar",
        "@com_fasterxml_jackson_core_jackson_annotations//jar",
        "@com_fasterxml_jackson_core_jackson_core//jar",
        "@org_codehaus_jackson_jackson_core_asl//jar",
        "@org_codehaus_jackson_jackson_mapper_asl//jar",
    ],
)

load("@io_bazel_rules_docker//go:image.bzl", "go_image")

#go_image(
#    name = "baffold-go-root",
#    embed = ["//baffold-go:baffold-go_linux_bin"],
#    goos = "linux",
#    goarch = "amd64",
#    static = "on",
#)

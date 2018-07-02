workspace(name = "eventstream")

git_repository(
    name = "io_bazel_rules_docker",
    remote = "https://github.com/bazelbuild/rules_docker.git",
    tag = "v0.4.0",
)

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "feba3278c13cde8d67e341a837f69a029f698d7a27ddbb2a202be7a10b22142a",
    url = "https://github.com/bazelbuild/rules_go/releases/download/0.10.3/rules_go-0.10.3.tar.gz",
)

http_archive(
    name = "bazel_gazelle",
    url = "https://github.com/bazelbuild/bazel-gazelle/releases/download/0.11.0/bazel-gazelle-0.11.0.tar.gz",
    sha256 = "92a3c59734dad2ef85dc731dbcb2bc23c4568cded79d4b87ebccd787eb89e8d0",
)
http_archive(
	name = "trans_maven_jar",
	url = "https://github.com/bazelbuild/migration-tooling/archive/master.zip",
	type = "zip",
	strip_prefix = "migration-tooling-master",
)

# load go rules
load("@io_bazel_rules_go//go:def.bzl", "go_rules_dependencies", "go_register_toolchains", "go_repository")
go_rules_dependencies()
go_register_toolchains()

# load gazelle
load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")
gazelle_dependencies()

load(
    "@io_bazel_rules_docker//go:image.bzl",
    _go_image_repos = "repositories",
)

_go_image_repos()

# Loads Docker rules for java
load(
    "@io_bazel_rules_docker//java:image.bzl",
    _java_image_repos = "repositories",
)

_java_image_repos()

# Load transivite maven rules
load("@trans_maven_jar//transitive_maven_jar:transitive_maven_jar.bzl", "transitive_maven_jar")

transitive_maven_jar(
	name = "dependencies",
	artifacts = [
		"org.apache.kafka:kafka-clients:1.1.0",
		"org.apache.avro:avro:1.8.1",
        "org.slf4j:slf4j-api:1.7.25",
        "com.fasterxml.jackson.core:jackson-databind:2.9.5",
        "com.fasterxml.jackson.core:jackson-annotations:2.9.0",
        "com.fasterxml.jackson.core:jackson-core:2.9.5",
        "org.apache.kafka:kafka-streams:1.1.0",
        "org.apache.kafka:connect-api:1.1.0",
        "org.antlr:antlr4-runtime:4.7",
        "io.airlift:slice:0.29",
        "org.openjdk.jol:jol-core:0.2",
        "org.codehaus.janino:janino:3.0.7",
        "org.codehaus.janino:commons-compiler:3.0.7",
	],
    repositories = [
        "http://central.maven.org/maven2/",
        ],
)

load("@dependencies//:generate_workspace.bzl", "generated_maven_jars")
generated_maven_jars()

# Maven servers

maven_server(
    name = "confluent_server",
    url = "http://packages.confluent.io/maven/",
)

# Maven jars

maven_jar(
    name = "io_confluent_kafka_avro_serializer",
    artifact = "io.confluent:kafka-avro-serializer:3.3.1",
    server = "confluent_server",
)

maven_jar(
    name = "io_confluent_common_config",
    artifact = "io.confluent:common-config:jar:4.1.1",
    server = "confluent_server",
)

maven_jar(
    name = "io_confluent_common_utils",
    artifact = "io.confluent:common-utils:4.1.1",
    server = "confluent_server",
)

maven_jar(
    name = "io_confluent_kafka_schema_registry_client",
    artifact = "io.confluent:kafka-schema-registry-client:4.1.1",
    server = "confluent_server",
)

maven_jar(
    name = "org_codehaus_jackson_jackson_core_asl",
    artifact = "org.codehaus.jackson:jackson-core-asl:1.9.13",
)

maven_jar(
    name = "org_codehaus_jackson_jackson_mapper_asl",
    artifact = "org.codehaus.jackson:jackson-mapper-asl:1.9.13",
)


maven_jar(
    name = "io_confluent_ksql_ksql_engine",
    artifact = "io.confluent.ksql:ksql-engine:4.1.1",
    server = "confluent_server",
)


maven_jar(
    name = "io_confluent_ksql_ksql_common",
    artifact = "io.confluent.ksql:ksql-common:4.1.1",
    server = "confluent_server",
)


maven_jar(
    name = "io_confluent_ksql_ksql_parser",
    artifact = "io.confluent.ksql:ksql-parser:4.1.1",
    server = "confluent_server",
)

maven_jar(
    name = "io_confluent_ksql_ksql_metastore",
    artifact = "io.confluent.ksql:ksql-metastore:4.1.1",
    server = "confluent_server",
)

#com.google.guava:guava:jar:21.0
maven_jar(
    name = "com_google_guava_guava",
    artifact = "com.google.guava:guava:21.0",
)

#io.confluent.ksql:ksql-serde:jar:4.1.1
maven_jar(
    name = "io_confluent_ksql_ksql_serde",
    artifact = "io.confluent.ksql:ksql-serde:4.1.1",
    server = "confluent_server",
)

#maven_jar(
#    name = "org_codehaus_jackson_jackson_mapper_asl",
#    artifact = "org.codehaus.jackson:jackson-mapper-asl:1.9.13",
#)


#maven_jar(
#    name = "kafka_avro_serializer",
#    artifact = "io.confluent:kafka-avro-serializer:3.3.1",
#    server = "confluent_server",
#)


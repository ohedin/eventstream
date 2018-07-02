package consumer;

import java.util.Collections;
import java.util.Properties;

import io.confluent.ksql.KsqlContext;
import io.confluent.ksql.util.KsqlConfig;

public class MyKSQLConsumer {

  public static void main(String[] args) throws Exception {

    System.out.println("Hello KSQL  !!");

    String servers = "kafka:9092";
    String registry = "http://schema:8081";

    Properties props = new Properties();
    props.put("bootstrap.servers", servers);
    props.put("listeners", "http://localhost:8088");
    props.put("ui.enabled", "true");
    props.put("auto.offset.reset", "earliest");

    props.put("acks", "all");
    props.put("retries", 0);
//    props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
//    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    props.put("ksql.schema.registry.url", registry);

    KsqlContext ksqlContext = KsqlContext.create(new KsqlConfig(props));

    //ksqlContext.sql("REGISTER TOPIC PAGE_VISITS WITH (format = 'avro', "
    //                + "kafka_topic='PAGE_VISITS');");

    //ksqlContext.sql("CREATE STREAM VISITS (time long, site varchar, ip varchar) WITH (kafka_topic='PAGE_VISITS', value_format='avro');");
    ksqlContext.sql("CREATE TABLE VISITS_BY_SITE (visits int, ip varchar) WITH (kafka_topic='PAGE_VISITS', value_format='avro') AS SELECT COUNT(*) as visits, ip FROM PAGE_VISITS GROUP BY site;");

    //ksqlContext.sql("CREATE STREAM VISITS AS SELECT * FROM PAGE_VISITS;");
    ksqlContext.sql("SELECT * FROM VISITS;");

    System.out.println("Queries are running ! ");

  }
  
}
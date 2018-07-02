package producer;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class MyProducer {

  public static void main(String[] args) throws Exception {

    System.out.println("Hello Producer !!");

    String servers = "kafka:9092";
    String registry = "http://schema:8081";

    Properties props = new Properties();
    props.put("bootstrap.servers", servers);
    props.put("acks", "all");
    props.put("retries", 0);
//    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//    props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");
    props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
    props.put("schema.registry.url", registry);

    String schemaString = "{\"namespace\": \"example.avro\", \"type\": \"record\", " +
                           "\"name\": \"page_visit\"," +
                           "\"fields\": [" +
                            "{\"name\": \"time\", \"type\": \"long\"}," +
                            "{\"name\": \"site\", \"type\": \"string\"}," +
                            "{\"name\": \"ip\", \"type\": \"string\"}" +
                           "]}";
    Producer<String, GenericRecord> producer = new KafkaProducer<String, GenericRecord>(props);

    Schema.Parser parser = new Schema.Parser();
    Schema schema = parser.parse(schemaString);

    Random rnd = new Random();
    for (long nEvents = 0; nEvents < 10; nEvents++) {
      long runtime = new Date().getTime();
      String site = "www.example.com";
      String ip = "192.168.2." + rnd.nextInt(255);

      GenericRecord page_visit = new GenericData.Record(schema);
      page_visit.put("time", runtime);
      page_visit.put("site", site);
      page_visit.put("ip", ip);

      ProducerRecord<String, GenericRecord> data = new ProducerRecord<String, GenericRecord>(
          "PAGE_VISITS", ip, page_visit);
      producer.send(data);
      System.out.println("message send : " + data);
    }

    producer.close();
  }
  
}
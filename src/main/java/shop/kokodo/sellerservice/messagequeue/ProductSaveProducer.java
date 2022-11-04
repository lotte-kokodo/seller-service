package shop.kokodo.sellerservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.KafkaProduct;
import shop.kokodo.sellerservice.dto.KafkaProductTemplate;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;

@Slf4j
@Service
public class ProductSaveProducer {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProductSaveProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public <T> void send(String topic, T kafkaProduct) {
        String jsonInString = "";
        try {
            jsonInString = objectMapper.writeValueAsString(kafkaProduct);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("kafka Producer sent data from Seller Product save : " + kafkaProduct);

    }


}

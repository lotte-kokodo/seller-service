package shop.kokodo.sellerservice.messagequeue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import shop.kokodo.sellerservice.dto.product.request.RequestProduct;

@Slf4j
@Service
public class ProductSaveProducer {

    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    public ProductSaveProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public RequestProduct send(String topic, RequestProduct requestProduct) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonInString = "";
        try {
            jsonInString = mapper.writeValueAsString(requestProduct);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);
        log.info("kafka Producer sent data from Seller Product save : " + requestProduct);

        return requestProduct;
    }
}

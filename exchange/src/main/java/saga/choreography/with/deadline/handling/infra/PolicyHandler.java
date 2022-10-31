package saga.choreography.with.deadline.handling.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import saga.choreography.with.deadline.handling.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import saga.choreography.with.deadline.handling.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired ExchangeRepository exchangeRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCreated'")
    public void wheneverOrderCreated_Exchange(@Payload OrderCreated orderCreated){

        OrderCreated event = orderCreated;
        System.out.println("\n\n##### listener Exchange : " + orderCreated + "\n\n");


        

        // Sample Logic //
        Exchange.exchange(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_Compensate(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener Compensate : " + orderRejected + "\n\n");


        

        // Sample Logic //
        Exchange.compensate(event);
        

        

    }

}



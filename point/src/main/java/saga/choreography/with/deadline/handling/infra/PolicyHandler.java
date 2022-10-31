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
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='ExchangeSucceeded'")
    public void wheneverExchangeSucceeded_UsePoint(@Payload ExchangeSucceeded exchangeSucceeded){

        ExchangeSucceeded event = exchangeSucceeded;
        System.out.println("\n\n##### listener UsePoint : " + exchangeSucceeded + "\n\n");


        

        // Sample Logic //
        Point.usePoint(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderRejected'")
    public void wheneverOrderRejected_Compensate(@Payload OrderRejected orderRejected){

        OrderRejected event = orderRejected;
        System.out.println("\n\n##### listener Compensate : " + orderRejected + "\n\n");


        

        // Sample Logic //
        Point.compensate(event);
        

        

    }

}



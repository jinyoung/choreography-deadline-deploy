package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.ExchangeSucceeded;
import saga.choreography.with.deadline.handling.domain.ExchangeFailed;
import saga.choreography.with.deadline.handling.domain.ExchangeCompensated;
import saga.choreography.with.deadline.handling.ExchangeApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Exchange_table")
@Data

public class Exchange  {

    
    
    
    
    
    private Long currencyId;
    
    
    
    
    
    private Long amount;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Double rate;
    
    
    
    
    
    private Double pointUsed;

    @PostPersist
    public void onPostPersist(){


        ExchangeSucceeded exchangeSucceeded = new ExchangeSucceeded(this);
        exchangeSucceeded.publishAfterCommit();



        ExchangeFailed exchangeFailed = new ExchangeFailed(this);
        exchangeFailed.publishAfterCommit();



        ExchangeCompensated exchangeCompensated = new ExchangeCompensated(this);
        exchangeCompensated.publishAfterCommit();

    }

    public static ExchangeRepository repository(){
        ExchangeRepository exchangeRepository = ExchangeApplication.applicationContext.getBean(ExchangeRepository.class);
        return exchangeRepository;
    }

    public void decreaseStock(){
        //
    }



    public static void exchange(OrderCreated orderCreated){

        /** Example 1:  new item 
        Exchange exchange = new Exchange();
        repository().save(exchange);

        ExchangeSucceeded exchangeSucceeded = new ExchangeSucceeded(exchange);
        exchangeSucceeded.publishAfterCommit();
        ExchangeFailed exchangeFailed = new ExchangeFailed(exchange);
        exchangeFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCreated.get???()).ifPresent(exchange->{
            
            exchange // do something
            repository().save(exchange);

            ExchangeSucceeded exchangeSucceeded = new ExchangeSucceeded(exchange);
            exchangeSucceeded.publishAfterCommit();
            ExchangeFailed exchangeFailed = new ExchangeFailed(exchange);
            exchangeFailed.publishAfterCommit();

         });
        */

        
    }
    public static void compensate(OrderRejected orderRejected){

        /** Example 1:  new item 
        Exchange exchange = new Exchange();
        repository().save(exchange);

        ExchangeCompensated exchangeCompensated = new ExchangeCompensated(exchange);
        exchangeCompensated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(exchange->{
            
            exchange // do something
            repository().save(exchange);

            ExchangeCompensated exchangeCompensated = new ExchangeCompensated(exchange);
            exchangeCompensated.publishAfterCommit();

         });
        */

        
    }


}

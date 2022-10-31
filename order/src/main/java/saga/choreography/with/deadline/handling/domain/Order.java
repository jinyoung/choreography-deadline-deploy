package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.OrderCreated;
import saga.choreography.with.deadline.handling.domain.OrderPlaced;
import saga.choreography.with.deadline.handling.domain.OrderRejected;
import saga.choreography.with.deadline.handling.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String currencyId;
    
    
    
    
    
    private Double amount;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String holderId;

    @PostPersist
    public void onPostPersist(){


        OrderCreated orderCreated = new OrderCreated(this);
        orderCreated.publishAfterCommit();



        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();



        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void reject(ExchangeFailed exchangeFailed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(exchangeFailed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

        
    }
    public static void reject(DeadlineReached deadlineReached){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(deadlineReached.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

        
    }
    public static void reject(PointUseFailed pointUseFailed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pointUseFailed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

        
    }
    public static void approve(PointUsed pointUsed){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderPlaced orderPlaced = new OrderPlaced(order);
        orderPlaced.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pointUsed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderPlaced orderPlaced = new OrderPlaced(order);
            orderPlaced.publishAfterCommit();

         });
        */

        
    }


}

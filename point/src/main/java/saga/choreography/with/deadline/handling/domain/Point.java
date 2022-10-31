package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.PointUsed;
import saga.choreography.with.deadline.handling.domain.PointUseFailed;
import saga.choreography.with.deadline.handling.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Point_table")
@Data

public class Point  {

    
    
    
    
    
    private Double point;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private String userId;

    @PostPersist
    public void onPostPersist(){


        PointUsed pointUsed = new PointUsed(this);
        pointUsed.publishAfterCommit();



        PointUseFailed pointUseFailed = new PointUseFailed(this);
        pointUseFailed.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void usePoint(ExchangeSucceeded exchangeSucceeded){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointUsed pointUsed = new PointUsed(point);
        pointUsed.publishAfterCommit();
        PointUseFailed pointUseFailed = new PointUseFailed(point);
        pointUseFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(exchangeSucceeded.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointUsed pointUsed = new PointUsed(point);
            pointUsed.publishAfterCommit();
            PointUseFailed pointUseFailed = new PointUseFailed(point);
            pointUseFailed.publishAfterCommit();

         });
        */

        
    }
    public static void compensate(OrderRejected orderRejected){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);


         });
        */

        
    }


}

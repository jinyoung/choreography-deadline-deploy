package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private String currencyId;
    private Double amount;
    private String holderId;

    public OrderCreated(Order aggregate){
        super(aggregate);
    }
    public OrderCreated(){
        super();
    }
}

package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private String currencyId;
    private Double amount;
    private String holderId;

    public OrderRejected(Order aggregate){
        super(aggregate);
    }
    public OrderRejected(){
        super();
    }
}

package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ExchangeSucceeded extends AbstractEvent {

    private Long orderId;
    private String userId;
    private Long currencyId;
    private Long amount;
    private Double rate;
    private Double pointUsed;

    public ExchangeSucceeded(Exchange aggregate){
        super(aggregate);
    }
    public ExchangeSucceeded(){
        super();
    }
}

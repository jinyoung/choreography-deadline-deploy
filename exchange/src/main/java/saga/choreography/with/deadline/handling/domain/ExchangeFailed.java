package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ExchangeFailed extends AbstractEvent {

    private Long orderId;
    private Long currencyId;
    private Long amount;
    private Double rate;

    public ExchangeFailed(Exchange aggregate){
        super(aggregate);
    }
    public ExchangeFailed(){
        super();
    }
}

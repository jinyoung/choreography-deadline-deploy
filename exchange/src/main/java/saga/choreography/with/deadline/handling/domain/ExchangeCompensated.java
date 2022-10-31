package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ExchangeCompensated extends AbstractEvent {

    private Long id;

    public ExchangeCompensated(Exchange aggregate){
        super(aggregate);
    }
    public ExchangeCompensated(){
        super();
    }
}

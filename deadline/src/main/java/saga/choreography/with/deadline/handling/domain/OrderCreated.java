package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderCreated extends AbstractEvent {

    private Long id;
    private String currencyId;
    private Double amount;
    private String holderId;
}



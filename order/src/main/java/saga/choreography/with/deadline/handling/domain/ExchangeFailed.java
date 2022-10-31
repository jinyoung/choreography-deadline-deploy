package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ExchangeFailed extends AbstractEvent {

    private Long orderId;
    private Long currencyId;
    private Long amount;
    private Double rate;
}



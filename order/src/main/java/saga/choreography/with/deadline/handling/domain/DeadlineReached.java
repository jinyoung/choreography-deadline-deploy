package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class DeadlineReached extends AbstractEvent {

    private Long id;
    private Date deadline;
    private Long orderId;
    private Date startedTime;
}



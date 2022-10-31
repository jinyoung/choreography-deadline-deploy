package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PointUseFailed extends AbstractEvent {

    private Long id;
    private String reason;
    private Long orderId;
}



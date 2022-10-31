package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class PointUsed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Double point;
    private Long orderId;
}



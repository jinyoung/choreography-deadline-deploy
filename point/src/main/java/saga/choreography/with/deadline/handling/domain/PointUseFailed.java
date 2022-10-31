package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointUseFailed extends AbstractEvent {

    private Long id;
    private String reason;
    private Long orderId;

    public PointUseFailed(Point aggregate){
        super(aggregate);
    }
    public PointUseFailed(){
        super();
    }
}

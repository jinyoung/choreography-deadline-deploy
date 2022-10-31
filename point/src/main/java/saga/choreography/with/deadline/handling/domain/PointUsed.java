package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import saga.choreography.with.deadline.handling.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointUsed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Double point;
    private Long orderId;

    public PointUsed(Point aggregate){
        super(aggregate);
    }
    public PointUsed(){
        super();
    }
}

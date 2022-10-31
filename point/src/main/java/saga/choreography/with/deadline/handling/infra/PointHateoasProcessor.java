package saga.choreography.with.deadline.handling.infra;
import saga.choreography.with.deadline.handling.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class PointHateoasProcessor implements RepresentationModelProcessor<EntityModel<Point>>  {

    @Override
    public EntityModel<Point> process(EntityModel<Point> model) {

        
        return model;
    }
    
}

package saga.choreography.with.deadline.handling.domain;

import saga.choreography.with.deadline.handling.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="points", path="points")
public interface PointRepository extends PagingAndSortingRepository<Point, String>{

}

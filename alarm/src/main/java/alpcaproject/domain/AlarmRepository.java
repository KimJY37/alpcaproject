package alpcaproject.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="alarms", path="alarms")
public interface AlarmRepository extends PagingAndSortingRepository<Alarm, String>{
    Optional<Alarm> findByMoveId(String moveId);
}
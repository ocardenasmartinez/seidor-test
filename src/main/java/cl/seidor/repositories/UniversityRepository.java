package cl.seidor.repositories;

import cl.seidor.entities.data.UniversityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends CrudRepository<UniversityEntity, Integer> {

    UniversityEntity findByName(String name);

}

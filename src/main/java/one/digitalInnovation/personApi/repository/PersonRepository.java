package one.digitalInnovation.personApi.repository;

import one.digitalInnovation.personApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

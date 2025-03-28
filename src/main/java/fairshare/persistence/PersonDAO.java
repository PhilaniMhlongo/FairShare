package fairshare.persistence;



import fairshare.model.Person;

import java.util.Optional;

public interface PersonDAO {
    Optional<Person> findPersonByEmail(String email);
    Person savePerson(Person person);
}

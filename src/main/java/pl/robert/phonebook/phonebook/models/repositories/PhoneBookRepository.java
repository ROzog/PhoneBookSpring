package pl.robert.phonebook.phonebook.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.robert.phonebook.phonebook.models.PhoneBookEntity;

@Repository
public interface PhoneBookRepository extends CrudRepository<PhoneBookEntity, Integer> {
    boolean existsByTelnumber(int telnumber);
}

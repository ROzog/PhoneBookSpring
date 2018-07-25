package pl.robert.phonebook.phonebook.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.robert.phonebook.phonebook.models.PhoneBookEntity;
import pl.robert.phonebook.phonebook.models.forms.PhoneBookForm;
import pl.robert.phonebook.phonebook.models.repositories.PhoneBookRepository;

@Service
public class AuthService {
    final PhoneBookRepository phoneBookRepository;

    @Autowired
    public AuthService(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    public boolean tryToAddNumber(PhoneBookForm phoneBookForm) {
        if (phoneBookRepository.existsByTelnumber(phoneBookForm.getTelnumber())) {
            return false;
        }
        PhoneBookEntity phoneBookEntity = createEntityFromForm(phoneBookForm);
        phoneBookRepository.save(phoneBookEntity);
        return true;
    }

    private PhoneBookEntity createEntityFromForm(PhoneBookForm phoneBookForm) {
        PhoneBookEntity phoneBookEntity = new PhoneBookEntity();
        phoneBookEntity.setName(phoneBookForm.getName());
        phoneBookEntity.setSurname(phoneBookForm.getSurname());
        phoneBookEntity.setTelnumber(phoneBookForm.getTelnumber());
        return phoneBookEntity;
    }
}

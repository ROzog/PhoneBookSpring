package pl.robert.phonebook.phonebook.models;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "phonebook")
@Data
public class PhoneBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String surname;
    private int telnumber;
}

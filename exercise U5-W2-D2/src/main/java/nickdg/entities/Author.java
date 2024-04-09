package nickdg.entities;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthday;
    private String avatar;

    public Author(String name, String surname, String email, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
    }
}

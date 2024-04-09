package nickdg.services;

import nickdg.entities.Author;
import nickdg.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private final List<Author> authorList = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorList;
    }

    public Author save(Author body) {
        body.setId(new Random().nextLong(100000000, 888888888));
        body.setAvatar("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        this.authorList.add(body);
        return body;
    }

    public Author findById(long id) {
        Author found = null;
        for (Author author : this.authorList) {
            if(author.getId() == id) found = author;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }

    public Author update(long id, Author updatedBody) {
        Author found = this.findById(id);
        found.setAvatar("https://ui-avatars.com/api/?name=" + updatedBody.getName() + "+" + updatedBody.getSurname());
        found.setName(updatedBody.getName());
        found.setSurname(updatedBody.getSurname());
        found.setEmail(updatedBody.getEmail());
        found.setBirthday(updatedBody.getBirthday());
        return found;
    }

    public void delete(long id) {
        Author found = this.findById(id);
        this.authorList.remove(found);
    }
}

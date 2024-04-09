package nickdg.controllers;

import nickdg.entities.Author;
import nickdg.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService as;

    @GetMapping
    private List<Author> getAllAuthors() {
        return as.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author saveAuthor(@RequestBody Author body) {
        return as.save(body);
    }

    @GetMapping("/{id}")
    private Author getAuthorById(@PathVariable long id) {
        return as.findById(id);
    }

    @PutMapping("/{id}")
    private Author updateAuthor(@PathVariable long id, @RequestBody Author body) {
        return as.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteAuthor(@PathVariable long id) {
        as.delete(id);
    }
}

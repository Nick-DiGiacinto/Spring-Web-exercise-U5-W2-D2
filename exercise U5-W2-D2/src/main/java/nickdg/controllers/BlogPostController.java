package nickdg.controllers;

import nickdg.entities.BlogPost;
import nickdg.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {
    @Autowired
    private BlogPostService bps;

    @GetMapping
    private List<BlogPost> getAllPosts() {
        return bps.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost savePost(@RequestBody BlogPost body) {
        return bps.save(body);
    }

    @GetMapping("/{id}")
    private BlogPost getPostById(@PathVariable long id) {
        return bps.findById(id);
    }

    @PutMapping("/{id}")
    private BlogPost updatePost(@PathVariable long id, @RequestBody BlogPost body) {
        return bps.update(id, body);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deletePost(@PathVariable long id) {
        bps.delete(id);
    }
}

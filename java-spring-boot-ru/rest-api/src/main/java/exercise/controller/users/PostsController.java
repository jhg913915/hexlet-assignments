package exercise.controller.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;
import exercise.Data;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/users")
public class PostsController {
    private final List<Post> posts = Data.getPosts(); // Get posts list from Data

    @GetMapping("/{id}/posts")
    public List<Post> index(@PathVariable Integer id) {
        return posts.stream()
                .filter(p -> p.getUserId() == id)
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable Integer id, @RequestBody PostRequest postRequest) {
        Post newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(postRequest.getSlug());
        newPost.setTitle(postRequest.getTitle());
        newPost.setBody(postRequest.getBody());
        posts.add(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPost);
    }

    @Getter
    @Setter
    static class PostRequest {
        private String slug;
        private String title;
        private String body;
    }
}

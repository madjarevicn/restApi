package wcs.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcs.restapi.entities.Comment;
import wcs.restapi.entities.Post;
import wcs.restapi.repos.CommentRepository;
import wcs.restapi.repos.PostRepository;

import java.util.List;
/**
 * @author NikolaMadjarevic
 */

@RestController
public class PostController {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    /*
        Dependency injection
     */
    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    /*
        Requests
     */
    @RequestMapping(path = "/posts" , method = RequestMethod.GET)
    public List<Post> getPosts(){
                return postRepository.findAll();
    }


    @RequestMapping(path = "/posts/{id}/comments",method = RequestMethod.GET)
    public List<Comment> findCommentsByPostId(@PathVariable String id){
        return commentRepository.findByPostId(id);
    }


    @RequestMapping(path="/posts/{id}",method = RequestMethod.GET)
    public Post getPostById(@PathVariable String id){
        return postRepository.findOne(id);
    }

    @RequestMapping(path ="/posts",method = RequestMethod.POST)
    public void addPost(@RequestBody List<Post> posts){
        for(Post p : posts)
        postRepository.save(p);
    }
    @RequestMapping(path = "/posts/{id}",method = RequestMethod.DELETE)
    public void deletePost(@PathVariable String id){
        postRepository.delete(id);
    }


    @RequestMapping(path = "/posts/{id}",method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post,@PathVariable String id){
        postRepository.save(post);
    }
}

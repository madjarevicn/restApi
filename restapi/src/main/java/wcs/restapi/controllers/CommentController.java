package wcs.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wcs.restapi.entities.Comment;
import wcs.restapi.repos.CommentRepository;

import java.util.List;

/**
 * @author NikolaMadjarevic
 */

@RestController
public class CommentController {

    private CommentRepository commentRepository;

    /*
        Dependency injection
     */
    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /*
        Requests
     */

    @RequestMapping(path = "/comments",method = RequestMethod.GET)
    public List<Comment> getComments(){

         return commentRepository.findAll();
    }
    @RequestMapping(path = "/comments",method = RequestMethod.POST)
    public void postComments(@RequestBody List<Comment> comments){
        for(Comment c : comments)
            commentRepository.save(c);
    }
    @RequestMapping(path = "/comments/{id}",method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable String id){
        commentRepository.delete(id);
    }



}

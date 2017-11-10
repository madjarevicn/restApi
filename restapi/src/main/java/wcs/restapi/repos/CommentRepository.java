package wcs.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import wcs.restapi.entities.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,String>{

    public List<Comment> findByPostId(String postId);

}

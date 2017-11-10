package wcs.restapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import wcs.restapi.entities.Post;

import java.util.List;
/**
 * @author NikolaMadjarevic
 */

public interface PostRepository extends JpaRepository<Post,String>{
    public List<Post> findByUserId(String userId);
}

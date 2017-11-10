package wcs.restapi.entities;


import org.springframework.boot.CommandLineRunner;

import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author NikolaMadjarevic
 */

@Entity
public class Comment {
    /*
    Entitet komentar
    Primarni kljuc sa notacijom id
     */
    @Id
    private String id;
    private String postId;
    private String name;
    private String email;
    private String body;

    public Comment(){

    }
    public Comment(String id, String postId, String name, String email, String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}



package lt.codeacademy.project.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    private String postTitle;

    private String postDescription;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentIdPost")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "postsIdUser")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "postIdGroup")
    private Group group;

}

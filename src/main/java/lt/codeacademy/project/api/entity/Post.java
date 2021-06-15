package lt.codeacademy.project.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 3, max = 50)
    private String postTitle;

    @NotBlank
    @Size(min = 10, max = 200)
    private String postDescription;

    @OneToMany
    @JoinColumn(name = "commentIdPost")
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "postsIdUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postIdGroup")
    private Group group;

}

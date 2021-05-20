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
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String surname;

    private String bio;

    private String username;

    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentIdUser")
    private Set<Comment> comments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "postsIdUser")
    private Set<Post> posts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userIdGroup")
    private Set<Group> groups;

}

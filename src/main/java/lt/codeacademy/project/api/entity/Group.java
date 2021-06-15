package lt.codeacademy.project.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String groupName;

    @Size(min = 3, max = 200)
    private String groupBio;

    @ManyToMany
    private Set<User> followers;

    @OneToMany
    @JoinColumn(name = "postIdGroup")
    private Set<Post> posts = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "userIdGroup")
    private User user;

}

package lt.codeacademy.project.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Size(min = 3, max = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name = "commentIdPost")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "commentIdUser")
    private User user;
}

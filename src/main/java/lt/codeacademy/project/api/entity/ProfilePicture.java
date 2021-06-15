package lt.codeacademy.project.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ProfilePicture {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(columnDefinition = "VARCHAR(100)")
    private String fileName;

    @Column(columnDefinition = "VARCHAR(30)")
    private String mediaType;

    @Column(columnDefinition = "int")
    private long size;

    @Lob
    private byte[] bytes;
}

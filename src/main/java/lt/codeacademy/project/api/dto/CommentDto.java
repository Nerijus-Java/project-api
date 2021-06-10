package lt.codeacademy.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.project.api.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private String id;
    private String description;
    private String username;
    private String userID;

    public List<CommentDto> parseList(List<Comment> comments) {
        return comments.stream().map(e -> parseObject(e)).collect(Collectors.toList());
    }

    public CommentDto parseObject(Comment comment) {
        return new CommentDto(comment.getId().toString(),
                comment.getDescription(),
                comment.getUser().getUsername(),
                comment.getUser().getId().toString());
    }
}

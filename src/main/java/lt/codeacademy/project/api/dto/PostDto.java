package lt.codeacademy.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.project.api.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private String id;
    private String postTitle;
    private String postDescription;
    private String username;
    private String userId;

    public List<PostDto> parseList(List<Post> posts) {
        return posts.stream().map(e -> parseObject(e)).collect(Collectors.toList());
    }

    public PostDto parseObject(Post post) {
        return new PostDto(post.getId().toString(),
                post.getPostTitle(),
                post.getPostDescription(),
                post.getUser().getUsername(),
                post.getUser().getId().toString());
    }
}

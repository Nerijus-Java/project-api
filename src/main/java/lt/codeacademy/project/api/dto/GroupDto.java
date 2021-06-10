package lt.codeacademy.project.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.project.api.entity.Group;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private String id;
    private String groupName;
    private String groupBio;
    private String username;
    private int followerAmount;

    public List<GroupDto> parseList(List<Group> groups) {
        return groups.stream().map(e -> parseObject(e)).collect(Collectors.toList());
    }

    public GroupDto parseObject(Group group) {
        return new GroupDto(
                group.getId().toString(),
                group.getGroupName(),
                group.getGroupBio(),
                group.getUser().getUsername(),
                group.getFollowers().size());
    }
}

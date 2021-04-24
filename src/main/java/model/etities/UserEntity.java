package model.etities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    private Long id;
    private Integer userId;
    private String name;
    private String email;
    private String gender;
    private String status;
    private String createdAt;
    private String updatedAt;
}
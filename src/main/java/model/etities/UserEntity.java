package model.etities;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
   private Long id;
   private String name;
   private String email;
   private String gender;
   private String status;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
}
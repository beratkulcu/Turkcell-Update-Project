package comtrkcll.entity.admin;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "t_admin")
public class Admin {

    @Id
    private Long adminId;

    private String adminName;
    private Long adminPass;
}

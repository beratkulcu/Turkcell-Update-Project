package comtrkcll.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Component
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "t_users")
public class User {

    @Id
    @Setter (AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank
    private String userName;

    @NotBlank
    private String userLastName;

    @NotBlank
    @Column(unique = true)
    private String phoneNumber;

    @NotBlank
    @Column(unique = true)
    private String email;

    private Long balance;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Packages packages;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SallaKazan sallaKazan;

    private LocalDateTime sallaKazanTime;


}

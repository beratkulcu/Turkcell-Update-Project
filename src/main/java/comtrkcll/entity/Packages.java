package comtrkcll.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "t_packages")
public class Packages {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Setter (AccessLevel.NONE)
    private Long packageId;


    private String packageName;

    private Long minute;
    private Long sms;
    private String internet;
    private Integer price;



}

package comtrkcll.entity;

import comtrkcll.entity.admin.MonthOrYears;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_home")
public class HomeInternetPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter (AccessLevel.NONE)
    private Long houseInternetId;

    private String houseInternetName;
    private Integer houseInternetGb;
    private String speedInfo;
    private Integer price;

    @Enumerated (EnumType.STRING)
    private MonthOrYears monthOrYears;

}

package comtrkcll.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OfferPackages {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long offerPackagesId;


    private String offerPackagesName;

    private Long minute;
    private Long sms;
    private Long internet;
    private Integer discountPrice;

    @ManyToOne
    private User user;
}

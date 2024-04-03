package comtrkcll.dto;

import comtrkcll.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class OfferPackagesDTO {



    private String offerPackagesName;
    private Long minute;
    private Long sms;
    private Long internet;
    private Integer discountPrice;

    @ManyToOne
    private User user;
}

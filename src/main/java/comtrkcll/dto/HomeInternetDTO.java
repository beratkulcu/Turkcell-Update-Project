package comtrkcll.dto;

import comtrkcll.entity.admin.MonthOrYears;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeInternetDTO {

    private String houseInternetName;
    private Integer houseInternetGb;
    private String speedInfo;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private MonthOrYears monthOrYears;
}

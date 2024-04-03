package comtrkcll.mapper.response;

import comtrkcll.dto.PackagesDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageResponse extends PackagesDTO {

    private String packageName;
    private Long minute;
    private Long sms;
    private String internet;
    private Integer price;
    private List<PackagesDTO> packagesDTOS;

}

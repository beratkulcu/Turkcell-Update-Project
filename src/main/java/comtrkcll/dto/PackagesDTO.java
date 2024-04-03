package comtrkcll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackagesDTO {

    private String packageName;
    private Long minute;
    private Long sms;
    private String internet;
    private Integer price;




}

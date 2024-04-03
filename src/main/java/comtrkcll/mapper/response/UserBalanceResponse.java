package comtrkcll.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBalanceResponse  {

    private String userName;
    private String userLastName;
    private String phoneNumber;
    private Long balance;
    private  String message = "Bakiyeniz yüklendi " + balance;


}

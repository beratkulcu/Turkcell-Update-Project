package comtrkcll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserDTO {


    private String userName;
    private String userLastName;
    private String phoneNumber;
    private String email;
    private Long balance;
    private PackagesDTO packagesDTOS;
    private SallaKazanDTO sallaKazanDTO;





}

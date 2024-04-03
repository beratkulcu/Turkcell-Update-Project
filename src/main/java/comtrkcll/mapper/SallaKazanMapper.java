package comtrkcll.mapper;

import comtrkcll.dto.SallaKazanDTO;
import comtrkcll.entity.SallaKazan;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class SallaKazanMapper {

    public SallaKazanDTO DTOchange (SallaKazan sallaKazan){
        SallaKazanDTO sallaKazanDTO = new SallaKazanDTO();
        sallaKazanDTO.setType(sallaKazan.getType());
        sallaKazanDTO.setLocalDateTime(sallaKazan.getLocalDateTime());
        return sallaKazanDTO;
    }
}

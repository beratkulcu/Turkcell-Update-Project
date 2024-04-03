package comtrkcll.dto;

import comtrkcll.entity.enums.Type;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SallaKazanDTO {
    @Enumerated(EnumType.STRING)
    private Type type;


    private long sallaKazanMinute = 500;
    private long sallaKazanSMS = 500;
    private long sallaKazanInternet = 50;
    private LocalDateTime localDateTime;
}

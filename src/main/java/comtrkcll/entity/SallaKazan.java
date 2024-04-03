package comtrkcll.entity;

import comtrkcll.entity.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Data
@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SallaKazan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sallaKazanId;

    @Enumerated (EnumType.STRING)
    private Type type;

    private LocalDateTime localDateTime;

    private Long sallaKazanValue;




}

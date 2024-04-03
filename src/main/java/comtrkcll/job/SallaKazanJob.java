package comtrkcll.job;

import comtrkcll.entity.SallaKazan;
import comtrkcll.entity.User;
import comtrkcll.entity.enums.Type;
import comtrkcll.repository.SallaKazanRepository;
import comtrkcll.repository.UserRepository;
import comtrkcll.service.SallaKazanService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class SallaKazanJob {

    private final SallaKazanService sallaKazanService;
    private final UserRepository userRepository;
    private final SallaKazanRepository sallaKazanRepository;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void SallaKazanKampanyası() {
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            SallaKazan sallaKazan = user.getSallaKazan();
            LocalDateTime sallaKazanTime = user.getSallaKazanTime();

            if (sallaKazan != null && sallaKazanTime != null) {
                LocalDateTime twentyFourHoursLater = sallaKazanTime.plusDays(1);

                if (LocalDateTime.now().isAfter(twentyFourHoursLater)) {
                    user.setSallaKazan(null);
                    sallaKazan.setSallaKazanValue(null);
                    userRepository.save(user);
                }
            }
        }
    }
}





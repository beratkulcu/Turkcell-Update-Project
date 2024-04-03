package comtrkcll.service;

import comtrkcll.dto.SallaKazanDTO;
import comtrkcll.entity.SallaKazan;
import comtrkcll.entity.User;
import comtrkcll.entity.enums.Type;
import comtrkcll.exception.DiscountedPackageNotFound;
import comtrkcll.exception.UserNotFound;
import comtrkcll.repository.SallaKazanRepository;
import comtrkcll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SallaKazanService {

    private final SallaKazanRepository sallaKazanRepository;
    private final UserRepository userRepository;
    private final Random random = new Random();


    public SallaKazanDTO sallaKazanKayit(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (user.getSallaKazan() != null){
                throw  new DiscountedPackageNotFound("Ayda 1 kere salla kazan kullanılır ");
            }

            Type[] types = Type.values();
            Random random = new Random();
            Type randomType = types[random.nextInt(types.length)];

            SallaKazan sallaKazan = new SallaKazan();
            sallaKazan.setType(randomType);
            sallaKazan.setLocalDateTime(LocalDateTime.now());

            sallaKazan.setType(randomType);
            switch (randomType) {
                case INTERNET:
                    sallaKazan.setSallaKazanValue(50L);
                    break;
                case SMS:
                    sallaKazan.setSallaKazanValue(500L);
                    break;
                case MINUTE:
                    sallaKazan.setSallaKazanValue(500L);
                    break;
            }

            user.setSallaKazan(sallaKazan);
            user.setSallaKazanTime(LocalDateTime.now());

            userRepository.save(user);
            sallaKazanRepository.save(sallaKazan);

            SallaKazanDTO sallaKazanDTO = new SallaKazanDTO();
            BeanUtils.copyProperties(sallaKazan, sallaKazanDTO);
            return sallaKazanDTO;
        } else {
            throw new UserNotFound("User not found with ID: " + userId);
        }
    }




    public void deleteAllSallaKazan() {
        sallaKazanRepository.deleteAll();
    }

    /*
    public boolean sallaKazanKullanildimi(User user) {
        if (user.getSallaKazanTime() == null) {
            return true;
        } else {
            LocalDateTime oneMonthAgo = LocalDateTime.now().minusMonths(1);
            return user.getSallaKazanTime().isBefore(oneMonthAgo);
        }

     */
    }


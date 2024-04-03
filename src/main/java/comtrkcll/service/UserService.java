package comtrkcll.service;

import comtrkcll.dto.HomeInternetDTO;
import comtrkcll.dto.SallaKazanDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.HomeInternetPackages;
import comtrkcll.entity.Packages;
import comtrkcll.entity.User;
import comtrkcll.exception.NoBalanceException;
import comtrkcll.exception.PackageAlreadyAvailable;
import comtrkcll.exception.PackagesoNotFound;
import comtrkcll.exception.UserNotFound;
import comtrkcll.mapper.PackageMapper;
import comtrkcll.mapper.SallaKazanMapper;
import comtrkcll.mapper.UserMapper;
import comtrkcll.mapper.response.UserBalanceResponse;
import comtrkcll.repository.HomeInterneRepository;
import comtrkcll.repository.PackagesRepository;
import comtrkcll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PackagesRepository packagesRepository;
    private final HomeInterneRepository homeInterneRepository;
    private final PackageMapper packageMapper;
    private final SallaKazanMapper sallaKazanMapper;


    public UserDTO resigster(User user) {
       User savedUser = userRepository.save(user);
       UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(savedUser,userDTO);
       return userDTO;
    } //kayıt - giriş

    public UserDTO updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).orElseThrow(()-> new UserNotFound("Kullanıcı Bulunamadı"));

        user1.setUserName(user.getUserName());
        user1.setUserLastName(user.getUserLastName());
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setEmail(user.getEmail());

        User updatedUser = userRepository.save(user1);

        UserDTO userDTO = userMapper.mapperUserDto(updatedUser);
        return userDTO;

    } //güncelleme


    public ResponseEntity<UserDTO> userBuysPackages(Long userId, Long packageId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFound("Kullanıcı Bulunamadı !!"));
        Packages packages = packagesRepository.findById(packageId)
                .orElseThrow(()-> new PackagesoNotFound("Paket Bulunamadı"));

        if (user.getBalance() < packages.getPrice()){
            throw new NoBalanceException("Yetersiz Bakiye");
        }
        if (user.getPackages() != null){
            throw new PackageAlreadyAvailable("Kullanıcı Paketi Zaten Mevcut");
        }

        user.setPackages(packages);

        user.setBalance(user.getBalance() - packages.getPrice());

        userRepository.save(user);




        UserDTO userDTO = new UserDTO(
                user.getUserName(),
                user.getUserLastName(),
                user.getPhoneNumber(),
                user.getEmail(),
                user.getBalance(),
                packageMapper.convertToDTO(packages),
                sallaKazanMapper.DTOchange(user.getSallaKazan())
        );

        return ResponseEntity.ok().body(userDTO);



    }


    public Object deletedUsers(Long userId) {
        Optional<User> user = userRepository.findById(userId);

        if (user.isPresent()){
            userRepository.deleteById(userId);
        }else {
            throw new UserNotFound("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    public UserBalanceResponse addBalanceInAccount(Long userId, Long balance) {
        Optional<User> optionalUser = userRepository.findById(userId);
       UserBalanceResponse userBalanceResponse = new UserBalanceResponse();

        if (optionalUser.isPresent()){
            User user = optionalUser.get();
           user.setBalance(user.getBalance() + balance);
           userBalanceResponse.setMessage("Bakiyeniz Yüklendi" + "/" + balance);

           BeanUtils.copyProperties(user , userBalanceResponse);
           userRepository.save(user);
        }else {
            throw new UserNotFound("Kullanıcı bulunamadı");
        }
        return userBalanceResponse;
    }

    public String deletedByUserPackage(Long userId, Long packageId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFound("kullanıcı yok"));
        Packages packages = packagesRepository.findById(packageId)
                .orElseThrow(()-> new PackagesoNotFound("Paket mevcut değil"));

        if (user.getPackages()!= null){
            throw new PackagesoNotFound("Kullanıcının böyle bir paketi yok");
        }


        user.setPackages(null);
        user.setBalance(user.getBalance() - 150);
        userRepository.save(user);

        return "Hesabınız Başarı ile silinmiştir + 150 TL taahhüt hesaptan çekilmiştir";


    }

    public HomeInternetDTO buyHomePackages(Long userId, Long homePackageId) {
        User user = userRepository.findById(userId)
                                        .orElseThrow(()-> new UserNotFound("kullanıcı yok"));
        HomeInternetPackages homeInternetPackages = homeInterneRepository.findById(homePackageId)
                                        .orElseThrow(()-> new  PackagesoNotFound("Paket bulunmadı"));

        if (user.getBalance() < homeInternetPackages.getPrice()){
            throw new NoBalanceException("Bakiyeniz Bu İşlem için yetersizdir : Lütfen Bakiye yükleyin");
        }
        if (user.getPackages() != null){
            throw new PackageAlreadyAvailable("Paketiniz mevcuttur . başka paket almak isterseniz paketinizi siliniz . silinen Pakette taahhüt ücreti alınır ");
        }
        return null;
    }




}

package comtrkcll.service;

import comtrkcll.dto.PackagesDTO;
import comtrkcll.dto.SallaKazanDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.Packages;
import comtrkcll.entity.User;
import comtrkcll.entity.enums.Type;
import comtrkcll.exception.PackagesoNotFound;
import comtrkcll.mapper.PackageMapper;
import comtrkcll.repository.PackagesRepository;
import comtrkcll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PackagesService {

    private final PackagesRepository packagesRepository;
    private final PackageMapper packageMapper;
    private final UserRepository userRepository;


    public Packages findById(Long id) {
        Optional<Packages> packages = packagesRepository.findById(id);

        if (!packages.isPresent()){
            throw  new PackagesoNotFound("Paket mevcut değildir");
        }
        Packages packages1 = packages.get();
        return packages1;
    }

    public PackagesDTO updatePackage(Long id, Packages packages) {
        Packages existİsPackage = packagesRepository.findById(id)
                .orElseThrow(()-> new PackagesoNotFound("Paket Mevcut Değil"));

            existİsPackage.setPackageName(packages.getPackageName());
            existİsPackage.setMinute(packages.getMinute());
            existİsPackage.setSms(packages.getSms());
            existİsPackage.setInternet(packages.getInternet());
            existİsPackage.setPrice(packages.getPrice());

            Packages updatedPackage = packagesRepository.save(existİsPackage);

            PackagesDTO packagesDTO = packageMapper.convertToDTO(updatedPackage);

            if (packagesDTO == null){
                throw new PackagesoNotFound("Böyle Bir paket mevcut Değildir");
            }

            return packagesDTO;


    }

    public List<UserDTO> findAllUsers() {
        List<User> savedUsers = userRepository.findAll();

        List<UserDTO> userDTOList = savedUsers.stream()
                .map(user -> {
                    UserDTO userDTO = new UserDTO();
                    userDTO.setUserName(user.getUserName());
                    userDTO.setUserLastName(user.getUserLastName());
                    userDTO.setEmail(user.getEmail());
                    userDTO.setBalance(user.getBalance());
                    userDTO.setPhoneNumber(user.getPhoneNumber());
                    userDTO.setPackagesDTOS(packageMapper.convertToDTO(user.getPackages()));

                    return userDTO;
                })
                .collect(Collectors.toList());

        return userDTOList;
    }

    public Object deletePackages(Long packageId) {
        Optional<Packages> optionalUser = packagesRepository.findById(packageId);

        if (optionalUser.isPresent()){
            packagesRepository.deleteById(packageId);
            userRepository.deleteById(packageId);
        }else {
            throw new PackagesoNotFound("Paket mevcut değildir");
        }
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}

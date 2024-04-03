package comtrkcll.mapper;

import comtrkcll.dto.PackagesDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.Packages;
import comtrkcll.entity.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PackageMapper packageMapper;
    private final SallaKazanMapper sallaKazanMapper;

    public UserDTO mapperUserDto (User user){
        UserDTO userDTO =new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setUserLastName(user.getUserLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setBalance(user.getBalance());
        userDTO.setPackagesDTOS(packageMapper.convertToDTO(user.getPackages()));
        userDTO.setSallaKazanDTO(sallaKazanMapper.DTOchange(user.getSallaKazan()));

        return userDTO;
    }

    public PackagesDTO mapPackagesToPackagesDTO(Packages packages) {
        PackagesDTO packagesDTO = new PackagesDTO();
        packagesDTO.setPackageName(packages.getPackageName());
        packagesDTO.setMinute(packages.getMinute());
        packagesDTO.setSms(packages.getSms());
        packagesDTO.setInternet(packages.getInternet());
        packagesDTO.setPrice(packages.getPrice());
        return packagesDTO;
    }


    public boolean odemeYapildimi (Long user , Long packageId){
        return true;
    }


}

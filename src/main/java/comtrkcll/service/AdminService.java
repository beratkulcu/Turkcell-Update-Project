package comtrkcll.service;

import comtrkcll.dto.HomeInternetDTO;
import comtrkcll.dto.PackagesDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.HomeInternetPackages;
import comtrkcll.entity.Packages;
import comtrkcll.entity.User;
import comtrkcll.exception.UserNotFound;
import comtrkcll.mapper.UserMapper;
import comtrkcll.repository.HomeInterneRepository;
import comtrkcll.repository.PackagesRepository;
import comtrkcll.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminService {


    private final PackagesRepository packagesRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final HomeInterneRepository homeInterneRepository;

    public PackagesDTO addPackagesToAdmin(Packages packages) {
        Packages savePackages = packagesRepository.save(packages);
        if (savePackages != null) {
            PackagesDTO packagesDTO = new PackagesDTO();
            BeanUtils.copyProperties(savePackages, packagesDTO);
            return packagesDTO;
        } else {
            return null;
        }
    }

    public List<PackagesDTO> allPackages() {
        return packagesRepository.findAll().stream()
                .map(savedPackage -> {
                    PackagesDTO packagesDTO = new PackagesDTO();
                    BeanUtils.copyProperties(savedPackage, packagesDTO);
                    return packagesDTO;
                })
                .collect(Collectors.toList());
    }

    public UserDTO getByUser(Long id) {
      Optional<User> user =  userRepository.findById(id);

      if (user.isPresent()){
         User user2 = user.get();
          UserDTO userDTO = userMapper.mapperUserDto(user2);
         return userDTO;
      }else {
          throw  new UserNotFound("Böyle bir kullanıcı bulunamadı");
      }


    }

    public HomeInternetDTO homeInternetAdd(HomeInternetPackages homeInternetPackages) {
        HomeInternetPackages homeInternetPackages1 =   homeInterneRepository.save(homeInternetPackages);
            if (homeInternetPackages1 != null){
                HomeInternetDTO homeInternetDTO = new HomeInternetDTO();
                BeanUtils.copyProperties(homeInternetPackages1 , homeInternetDTO);
                return homeInternetDTO;
            }else {
                return  null;
            }
    }
}

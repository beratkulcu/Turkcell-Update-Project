package comtrkcll.controller;

import comtrkcll.dto.HomeInternetDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.User;
import comtrkcll.mapper.response.UserBalanceResponse;
import comtrkcll.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("register")
    public UserDTO registerUser(@RequestBody User user){
        return  userService.resigster(user);
    }

    @PutMapping("/{id}") //https localhost 8080 /1
    public ResponseEntity<UserDTO> updateToUser (@PathVariable Long id ,@RequestBody User user ){
        return ResponseEntity.ok(userService.updateUser(id,user));
    }


   @PutMapping("/buyPackage/{userId}/{packageId}")
    public ResponseEntity<UserDTO> userBuyPackage(@PathVariable Long userId , @PathVariable Long packageId){
        return userService.userBuysPackages(userId,packageId);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deletedUser (@PathVariable Long userId){
        userService.deletedUsers(userId);
        return ResponseEntity.ok("Kullanıcı Başarı ile Silindi :( ");
    }

    @PostMapping("/addBalance/{userId}/balance")
    public UserBalanceResponse addBalance (@PathVariable Long userId , @RequestParam("balance") Long balance){
       UserBalanceResponse userBalanceResponse = userService.addBalanceInAccount(userId,balance);
        return userBalanceResponse;
    }

    @PostMapping("/deleteByUserPackage/{userId}/{packageId}")
    public ResponseEntity<String> deleteUserPackage (@PathVariable Long userId ,
                                                     @PathVariable Long packageId){
      return ResponseEntity.ok().body(userService.deletedByUserPackage(userId,packageId));
    }


    @PostMapping("/buyHomePackage/{userId}/{homePackageId}")
    public ResponseEntity<HomeInternetDTO> buyHomeInternet
                                        (@PathVariable Long userId , @PathVariable Long homePackageId){
      return   ResponseEntity.ok().body(userService.buyHomePackages(userId,homePackageId));
    }


}

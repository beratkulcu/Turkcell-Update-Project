package comtrkcll.controller;

import comtrkcll.dto.HomeInternetDTO;
import comtrkcll.dto.PackagesDTO;
import comtrkcll.dto.UserDTO;
import comtrkcll.entity.HomeInternetPackages;
import comtrkcll.entity.Packages;
import comtrkcll.service.AdminService;
import comtrkcll.service.PackagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final PackagesService packagesService;

    @PostMapping("addPackages") //paket ekleme
    public ResponseEntity<PackagesDTO> addPackage(@RequestBody Packages packages){
      PackagesDTO packagesDTO =  adminService.addPackagesToAdmin(packages);
        return  ResponseEntity.ok(packagesDTO);
    }

    @GetMapping("getPackages")
    public List<PackagesDTO> getAllPackages(){

        return adminService.allPackages();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PackagesDTO> updatePackagaes (@PathVariable Long id , @RequestBody Packages packages){
        PackagesDTO updatePackagesDTO = packagesService.updatePackage(id,packages);
        return ResponseEntity.ok(updatePackagesDTO);
    }

    @GetMapping("getUsers")
    public List<UserDTO> getAllUsers(){
        return packagesService.findAllUsers();
    }

    @GetMapping("/getByUser/{id}")
    public ResponseEntity<UserDTO> getUserById (@PathVariable Long id){
       UserDTO userDTO =  adminService.getByUser(id);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/deletePackage/{packageId}")
    public ResponseEntity<String> deletePackage (@PathVariable Long packageId){
        packagesService.deletePackages(packageId);
        return ResponseEntity.ok("Paket silindi ");
    }

    @PostMapping("homeInternetAdd")
    public ResponseEntity<HomeInternetDTO> homeInternetAdd (@RequestBody HomeInternetPackages homeInternetPackages){
        HomeInternetDTO homeInternetDTO = adminService.homeInternetAdd(homeInternetPackages);
        return ResponseEntity.ok(homeInternetDTO);
    }
}

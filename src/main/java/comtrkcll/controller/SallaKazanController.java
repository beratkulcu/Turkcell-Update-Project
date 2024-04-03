package comtrkcll.controller;
import comtrkcll.dto.SallaKazanDTO;
import comtrkcll.entity.SallaKazan;
import comtrkcll.service.SallaKazanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("sallaKazan")
@RequiredArgsConstructor
public class SallaKazanController {

    private final SallaKazanService sallaKazanService;

    @PostMapping("/salla/{userId}")
    public ResponseEntity<SallaKazanDTO> sallaKazan (@PathVariable Long userId){

       SallaKazanDTO sallaKazanDTO =  sallaKazanService.sallaKazanKayit(userId);
        return ResponseEntity.ok(sallaKazanDTO);
    }

    @DeleteMapping("jobDel")
    public ResponseEntity<String> jobDelete(@RequestBody SallaKazan sallaKazan) {
        sallaKazanService.deleteAllSallaKazan();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("İşlem Tamam");
    }


}

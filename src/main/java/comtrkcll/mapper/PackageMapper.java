package comtrkcll.mapper;

import comtrkcll.dto.PackagesDTO;
import comtrkcll.entity.Packages;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PackageMapper {

    public PackagesDTO convertToDTO (Packages packages){
        PackagesDTO packagesDTO = new PackagesDTO();
        packagesDTO.setPackageName(packages.getPackageName());
        packagesDTO.setSms(packages.getSms());
        packagesDTO.setInternet(packages.getInternet());
        packagesDTO.setMinute(packages.getMinute());
        packagesDTO.setPrice(packages.getPrice());
        return packagesDTO;
    }


}

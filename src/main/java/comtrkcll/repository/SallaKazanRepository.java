package comtrkcll.repository;

import comtrkcll.entity.SallaKazan;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SallaKazanRepository extends JpaRepository<SallaKazan , Long> {


}

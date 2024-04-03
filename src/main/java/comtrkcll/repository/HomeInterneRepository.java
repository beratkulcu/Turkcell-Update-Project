package comtrkcll.repository;

import comtrkcll.entity.HomeInternetPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeInterneRepository extends JpaRepository<HomeInternetPackages, Long> {
}

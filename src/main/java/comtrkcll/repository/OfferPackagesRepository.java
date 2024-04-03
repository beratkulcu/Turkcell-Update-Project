package comtrkcll.repository;

import comtrkcll.entity.OfferPackages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferPackagesRepository extends JpaRepository<OfferPackages, Long> {
}

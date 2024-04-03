package comtrkcll.repository;

import comtrkcll.entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackagesRepository extends JpaRepository<Packages , Long> {

    List<Packages> findAll();



}

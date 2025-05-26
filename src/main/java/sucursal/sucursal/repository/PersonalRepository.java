package sucursal.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sucursal.sucursal.model.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Integer>{

    

    @SuppressWarnings("unchecked")
    Personal save(Personal personal);

    Personal findById(int idPersonal);

    List<Personal> findAll();
}

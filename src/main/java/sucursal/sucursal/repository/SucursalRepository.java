package sucursal.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sucursal.sucursal.model.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Integer> {


    @SuppressWarnings("unchecked")
    
    Sucursal save(Sucursal sucursal);

    Sucursal findById(int idSucursal);
    
    List<Sucursal> findAll();

    
}

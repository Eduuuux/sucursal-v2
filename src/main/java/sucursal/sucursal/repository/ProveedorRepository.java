package sucursal.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sucursal.sucursal.model.Proveedor;



@Repository

public interface ProveedorRepository extends JpaRepository <Proveedor,Integer> {
    @SuppressWarnings("unchecked")
    Proveedor save(Proveedor proveedor);

    Proveedor findById(int idProveedor);

    Proveedor findByRutProveedor(String rutProveedor);

    List<Proveedor> findAll();

}

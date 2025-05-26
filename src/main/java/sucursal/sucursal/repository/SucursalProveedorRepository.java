package sucursal.sucursal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sucursal.sucursal.model.SucursalProveedor;

@Repository
public interface SucursalProveedorRepository extends JpaRepository<SucursalProveedor, Integer> {
    @SuppressWarnings("unchecked")
    List<SucursalProveedor> findAll();

    List<SucursalProveedor> findBySucursal_IdSucursal(int idSucursal);
    List<SucursalProveedor> findBySucursal_IdSucursalAndProveedor_IdProveedor(int idSucursal, int idProveedor);
}

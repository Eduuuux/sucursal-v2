package sucursal.sucursal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal.sucursal.model.SucursalProveedor;
import sucursal.sucursal.repository.SucursalProveedorRepository;

@Service

public class SucursalProveedorService {
    @Autowired
    private SucursalProveedorRepository sucursalProveedorRepository;

    public List<SucursalProveedor> findAll() {
        return sucursalProveedorRepository.findAll();
    }

    public List<SucursalProveedor> findBySucursalId(int idSucursal) {
        return sucursalProveedorRepository.findBySucursal_IdSucursal(idSucursal);
    }

    public SucursalProveedor guardarSucursalProveedor(SucursalProveedor sucursalProveedor) {
        return sucursalProveedorRepository.save(sucursalProveedor);
    }

    
}

package sucursal.sucursal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal.sucursal.model.Proveedor;
import sucursal.sucursal.repository.ProveedorRepository;
@Service

public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }
    public Proveedor findById(int idProveedor) {
        return proveedorRepository.findById(idProveedor);
    }
    public Proveedor findByRutProveedor(String rutProveedor) {
        return proveedorRepository.findByRutProveedor(rutProveedor);
    }
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
}

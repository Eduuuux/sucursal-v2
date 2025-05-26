package sucursal.sucursal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sucursal.sucursal.model.Proveedor;
import sucursal.sucursal.service.ProveedorService;


@RestController
@RequestMapping("/proveedor")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    
    @GetMapping()
        public ResponseEntity<List<Proveedor>> getAll() {
            List<Proveedor> proveedores = proveedorService.findAll();
            if (!proveedores.isEmpty()) {
                return new ResponseEntity<>(proveedores, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
    
    

    @GetMapping("/{rutProveedor}")
    public ResponseEntity<Proveedor> getByRutProveedor(@PathVariable String rutProveedor) {
        Proveedor proveedor = proveedorService.findByRutProveedor(rutProveedor);
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



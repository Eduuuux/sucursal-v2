package sucursal.sucursal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sucursal.sucursal.DTO.SucursalProveedorDTO;
import sucursal.sucursal.model.Personal;
import sucursal.sucursal.model.Sucursal;
import sucursal.sucursal.model.SucursalProveedor;
import sucursal.sucursal.repository.SucursalProveedorRepository;
import sucursal.sucursal.service.PersonalService;
import sucursal.sucursal.service.SucursalService;




@RestController
@RequestMapping("api/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @GetMapping()
    public ResponseEntity<List<Sucursal>> getAll() {
        List<Sucursal> sucursales = sucursalService.findAll();
        if (!sucursales.isEmpty()) {
            return new ResponseEntity<>(sucursales, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> getById(@PathVariable int idSucursal) {
        Sucursal suc = sucursalService.findById(idSucursal);
        if (suc != null) {
            return new ResponseEntity<>(suc, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // @PostMapping("/registrar")
    // public ResponseEntity<Sucursal> postSucursal(@RequestBody Sucursal sucursal) {
    //     Sucursal suc = sucursalService.findById(sucursal.getIdSucursal());
    //     if (suc == null) {
    //         return new ResponseEntity<>(sucursalService.guardarSucursal(sucursal),HttpStatus.CREATED); // Conflict if the Sucursal already exists
    //     }
    //     else {
    //         return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); // Conflict if the Sucursal already exists
    //     }
    // }


    @PostMapping("/registrar")
    public ResponseEntity<?> postSucursal(@RequestBody Sucursal sucursal) {
        Sucursal suc = sucursalService.findById(sucursal.getIdSucursal());
        Map<String, Object> response = new HashMap<>();
        if (suc == null) {
            Sucursal nueva = sucursalService.guardarSucursal(sucursal);
            response.put("mensaje", "Sucursal " + nueva.getIdSucursal() + " creada correctamente");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.put("mensaje", "La sucursal ya existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @PutMapping("/actualizar/{idSucursal}")
    public ResponseEntity<?> updateById(@PathVariable int idSucursal, @RequestBody Sucursal sucursal) {
        Sucursal suc = sucursalService.updateById(idSucursal, sucursal);
        Map<String, Object> response = new HashMap<>();
        if (suc != null) {
            response.put("mensaje", "Sucursal " + suc.getIdSucursal() + " actualizada correctamente");
            response.put("sucursal", suc);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("mensaje", "No se encontró la sucursal");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    // @PutMapping("/actualizar/{idSucursal}")
    // public ResponseEntity<Sucursal>updateById(@PathVariable int idSucursal, @RequestBody Sucursal sucursal) {
    //     Sucursal suc = sucursalService.updateById(idSucursal, sucursal);
    //     if (suc != null) {
    //         return new ResponseEntity<>(suc, HttpStatus.OK);
    //     }
    //     else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }

    @DeleteMapping("/eliminar/{idSucursal}")
    public ResponseEntity<?> deleteById(@PathVariable int idSucursal) {
        Map<String, Object> response = new HashMap<>();
        try {
            Sucursal suc = sucursalService.deleteById(idSucursal);
            if (suc != null) {
                response.put("mensaje", "Sucursal " + suc.getIdSucursal() + " eliminada correctamente");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("mensaje", "No se encontró la sucursal");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            response.put("mensaje", "No se puede eliminar la sucursal porque tiene empleados asociados.");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        }
    }




    @Autowired
    private PersonalService personalService;

    @GetMapping("/{idSucursal}/personal")
    public ResponseEntity<List<Personal>> getPersonalBySucursal(@PathVariable int idSucursal) {
    List<Personal> personals = personalService.findBySucursalId(idSucursal);
    if (!personals.isEmpty()) {
        return new ResponseEntity<>(personals, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    }

    @Autowired
    private SucursalProveedorRepository sucursalProveedorRepository;
    
    @GetMapping("/{idSucursal}/contratos")
    public ResponseEntity<List<SucursalProveedorDTO>> getContratosBySucursal(@PathVariable int idSucursal) {
        List<SucursalProveedor> contratos = sucursalProveedorRepository.findBySucursal_IdSucursal(idSucursal);
        if (!contratos.isEmpty()) {
            // Transformar los datos en DTOs
            List<SucursalProveedorDTO> contratosDTO = contratos.stream()
                .map(contrato -> new SucursalProveedorDTO(
                    contrato.getId(),
                    contrato.getSucursal().getNombreSucursal(),
                    contrato.getSucursal().getDireccionSucursal(),
                    contrato.getProveedor().getNombreProveedor(),
                    contrato.getProveedor().getProductoProveedor()
                ))
                .toList();
            return new ResponseEntity<>(contratosDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

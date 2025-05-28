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

import sucursal.sucursal.model.Personal;
import sucursal.sucursal.service.PersonalService;





@RestController
@RequestMapping("api/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    // @GetMapping()
    // public ResponseEntity<List<Personal>> getAll(){
    //     List<Personal>  personals = personalService.findAll();
    //     if (!personals.isEmpty()) {
    //         return new ResponseEntity<>(personals, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    // }


    @GetMapping()
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        List<Personal> personals = personalService.findAll();
        if (!personals.isEmpty()) {
            List<Map<String, Object>> result = new java.util.ArrayList<>();
            
            for (Personal p : personals) {
                Map<String, Object> personalMap = new HashMap<>();
                personalMap.put("idPersonal", p.getIdPersonal());
                personalMap.put("rutPersonal", p.getRutPersonal());
                personalMap.put("nombrePersonal", p.getNombrePersonal());
                personalMap.put("apellidoPersonal", p.getApellidoPersonal());
                personalMap.put("telefonoPersonal", p.getTelefonoPersonal());
                personalMap.put("correoPersonal", p.getCorreoPersonal());
                personalMap.put("idSucursal", p.getSucursal() != null ? p.getSucursal().getIdSucursal() : null);
                result.add(personalMap);
            }
            
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/{idPersonal}")
    public ResponseEntity<Personal> getById(@PathVariable int idPersonal) {
        Personal pers = personalService.findById(idPersonal);
        if (pers != null) {
            return new ResponseEntity<>(pers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
    @PostMapping("/registrar")
    public ResponseEntity<?> postPersonal(@RequestBody Personal personal) {
        Personal pers = personalService.findById(personal.getIdPersonal());
        if (pers == null) {
            Personal nuevo = personalService.guardarPersonal(personal);
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Personal creado exitosamente");

            Map<String, Object> personalMap = new HashMap<>();
            personalMap.put("idPersonal", nuevo.getIdPersonal());
            personalMap.put("rutPersonal", nuevo.getRutPersonal());
            personalMap.put("nombrePersonal", nuevo.getNombrePersonal());
            personalMap.put("apellidoPersonal", nuevo.getApellidoPersonal());
            personalMap.put("telefonoPersonal", nuevo.getTelefonoPersonal());
            personalMap.put("correoPersonal", nuevo.getCorreoPersonal());
            personalMap.put("idSucursal", nuevo.getSucursal() != null ? nuevo.getSucursal().getIdSucursal() : null);

            response.put("personal", personalMap);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "El personal ya existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/actualizar/{idPersonal}")
        public ResponseEntity<?> updateById(@PathVariable int idPersonal, @RequestBody Personal personal) {
            Personal pers = personalService.updateById(idPersonal, personal);
            if (pers != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("mensaje", "Personal actualizado exitosamente");

                Map<String, Object> personalMap = new HashMap<>();
                personalMap.put("idPersonal", pers.getIdPersonal());
                personalMap.put("rutPersonal", pers.getRutPersonal());
                personalMap.put("nombrePersonal", pers.getNombrePersonal());
                personalMap.put("apellidoPersonal", pers.getApellidoPersonal());
                personalMap.put("telefonoPersonal", pers.getTelefonoPersonal());
                personalMap.put("correoPersonal", pers.getCorreoPersonal());
                personalMap.put("idSucursal", pers.getSucursal() != null ? pers.getSucursal().getIdSucursal() : null);

                response.put("personal", personalMap);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                Map<String, Object> response = new HashMap<>();
                response.put("mensaje", "No se encontró el personal");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

    }

    @DeleteMapping("/eliminar/{idPersonal}")
    public ResponseEntity<?> deleteById(@PathVariable int idPersonal) {
        Personal pers = personalService.deleteById(idPersonal);
        if (pers != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "Personal eliminado exitosamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("mensaje", "No se encontró el personal");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }




    // @GetMapping("/sucursal/{idSucursal}")
    // public ResponseEntity<List<Personal>> getBySucursalId(@PathVariable int idSucursal) {
    //     List<Personal> personals = personalService.findBySucursalId(idSucursal);
    //     if (!personals.isEmpty()) {
    //         return new ResponseEntity<>(personals, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //     }
    // }




    


    


}

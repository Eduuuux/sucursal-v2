package sucursal.sucursal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sucursal.sucursal.model.Personal;
import sucursal.sucursal.model.Sucursal;
import sucursal.sucursal.service.PersonalService;
import sucursal.sucursal.service.SucursalService;




@RestController
@RequestMapping("/sucursal")
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


    @PostMapping("/registrar")
    public ResponseEntity<Sucursal> postSucursal(@RequestBody Sucursal sucursal) {
        Sucursal suc = sucursalService.findById(sucursal.getIdSucursal());
        if (suc == null) {
            return new ResponseEntity<>(sucursalService.guardarSucursal(sucursal),HttpStatus.CREATED); // Conflict if the Sucursal already exists
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); // Conflict if the Sucursal already exists
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Sucursal>updateById(@PathVariable int idSucursal, @RequestBody Sucursal sucursal) {
        Sucursal suc = sucursalService.updateById(idSucursal, sucursal);
        if (suc != null) {
            return new ResponseEntity<>(suc, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    












}

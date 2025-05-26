package sucursal.sucursal.controller;

import java.util.List;

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
import sucursal.sucursal.service.PersonalService;





@RestController
@RequestMapping("/personal")
public class PersonalController {
    private PersonalService personalService;

    @GetMapping()
    public ResponseEntity<List<Personal>> getAll(){
        List<Personal>  personals = personalService.findAll();

        if (!personals.isEmpty()) {
            return new ResponseEntity<>(personals, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
    
    @PostMapping("/registrar")
    public ResponseEntity<Personal> postPersonal(@RequestBody Personal personal) {
        Personal pers = personalService.findById(personal.getIdPersonal());
        if (pers == null) {
            return new ResponseEntity<>(personalService.guardarPersonal(personal),HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/actualizar/{idPersonal}")
    public ResponseEntity<Personal> updateById(@PathVariable int idPersonal, @RequestBody Personal personal) {
        Personal pers = personalService.updateById(idPersonal, personal);
        if (pers != null) {
            return new ResponseEntity<>(pers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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




    


    


}

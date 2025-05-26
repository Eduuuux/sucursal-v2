package sucursal.sucursal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal.sucursal.model.Personal;
import sucursal.sucursal.repository.PersonalRepository;

@Service
public class PersonalService {
    @Autowired

    private PersonalRepository personalRepository;

    public List<Personal> findAll() {
        return personalRepository.findAll();
    }

    public Personal findById(int idPersonal) {
        return personalRepository.findById(idPersonal);
    }

    public Personal guardarPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    public Personal updateById(int idPersonal, Personal personal) {
        Personal pers = personalRepository.findById(idPersonal);

        if (pers != null) {
            if (pers.getNombrePersonal() != null) {
                personal.setNombrePersonal(pers.getNombrePersonal());
            }

            if (pers.getApellidoPersonal() != null) {
                personal.setApellidoPersonal(pers.getApellidoPersonal());
            }

            if (pers.getTelefonoPersonal() != null) {
                personal.setTelefonoPersonal(pers.getTelefonoPersonal());
            }
            if (pers.getCorreoPersonal() != null) {
                personal.setCorreoPersonal(pers.getCorreoPersonal());
            }

            return personalRepository.save(personal);
        } else {
            return null;
        }
     }
    }

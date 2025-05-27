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

    public List<Personal> findBySucursalId(int idSucursal) {
        return personalRepository.findBySucursal_IdSucursal(idSucursal);
}

    public Personal guardarPersonal(Personal personal) {
        return personalRepository.save(personal);
    }

    public Personal updateById(int idPersonal, Personal personal) {
        Personal pers = personalRepository.findById(idPersonal);

        if (pers != null) {
            if (personal.getNombrePersonal() != null) {
                pers.setNombrePersonal(personal.getNombrePersonal());
            }

            if (personal.getApellidoPersonal() != null) {
                pers.setApellidoPersonal(personal.getApellidoPersonal());
            }

            if (personal.getTelefonoPersonal() != null) {
                pers.setTelefonoPersonal(personal.getTelefonoPersonal());
            }
            if (personal.getCorreoPersonal() != null) {
                pers.setCorreoPersonal(personal.getCorreoPersonal());
            }
            if (personal.getSucursal() != null && personal.getSucursal() != null) {
            pers.setSucursal(personal.getSucursal());
            if (personal.getSucursal().getIdSucursal() == 0) {
                pers.setSucursal(null);
            }
            }

            personalRepository.save(pers);
            return pers;
        }
            return null;
        
    }

    public Personal deleteById(int idPersonal) {
        Personal pers = personalRepository.findById(idPersonal);
        if (pers != null) {
            personalRepository.delete(pers);
            return pers;
        }
        return null;
    }


}

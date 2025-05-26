package sucursal.sucursal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sucursal.sucursal.model.Sucursal;
import sucursal.sucursal.repository.SucursalRepository;



@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    public Sucursal findById(int idSucursal) {
        return sucursalRepository.findById(idSucursal);
    }

    public Sucursal guardarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    public Sucursal updateById(int idSucursal, Sucursal sucursal) {
        Sucursal suc = sucursalRepository.findById(idSucursal);

        if (suc != null) {
            if(suc.getNombreSucursal () != null) {
                sucursal.setNombreSucursal(suc.getNombreSucursal());
            }

            if(suc.getDireccionSucursal() != null) {
                sucursal.setDireccionSucursal(suc.getDireccionSucursal());
            }

            if(suc.getPoliticasLocales() != null) {
                sucursal.setPoliticasLocales(suc.getPoliticasLocales());
            }

            if(suc.getHorarioEntrada() != null) {
                sucursal.setHorarioEntrada(suc.getHorarioEntrada());
            }
            
            if(suc.getHorarioSalida() != null) {
                sucursal.setHorarioSalida(suc.getHorarioSalida());
            }
            
            if(suc.getTelefonoSucursal() != null) {
                sucursal.setTelefonoSucursal(suc.getTelefonoSucursal());
            }

            if(suc.getCodigoPostalSucursal() != 0) {
                sucursal.setCodigoPostalSucursal(suc.getCodigoPostalSucursal());
            }

            if(suc.getCiudadSucursal() != null) {
                sucursal.setCiudadSucursal(suc.getCiudadSucursal());
            }

            sucursalRepository.save(suc);
            return suc;

        }
        return null;
    
    
    
    
    

    }





}

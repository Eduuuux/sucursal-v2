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
            if(sucursal.getNombreSucursal () != null) {
                suc.setNombreSucursal(sucursal.getNombreSucursal());
            }

            if(sucursal.getDireccionSucursal() != null) {
                suc.setDireccionSucursal(sucursal.getDireccionSucursal());
            }

            if(sucursal.getPoliticasLocales() != null) {
                sucursal.setPoliticasLocales(sucursal.getPoliticasLocales());
            }

            if(sucursal.getHorarioEntrada() != null) {
                suc.setHorarioEntrada(sucursal.getHorarioEntrada());
            }
            
            if(sucursal.getHorarioSalida() != null) {
                suc.setHorarioSalida(sucursal.getHorarioSalida());
            }
            
            if(sucursal.getTelefonoSucursal() != null) {
                suc.setTelefonoSucursal(sucursal.getTelefonoSucursal());
            }

            if(sucursal.getCodigoPostalSucursal() != 0) {
                suc.setCodigoPostalSucursal(sucursal.getCodigoPostalSucursal());
            }

            if(sucursal.getCiudadSucursal() != null) {
                suc.setCiudadSucursal(sucursal.getCiudadSucursal());
            }

            sucursalRepository.save(suc);
            return suc;

        }
        return null;
    
    
    
    
    

    }





}

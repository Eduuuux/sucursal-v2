package sucursal.sucursal.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SucursalProveedorDTO {
    private int id;
    private String nombreSucursal;
    private String direccionSucursal;
    private String nombreProveedor;
    private String productoProveedor;
}

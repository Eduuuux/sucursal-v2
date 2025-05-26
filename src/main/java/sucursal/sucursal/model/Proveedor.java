package sucursal.sucursal.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;

    @Column(nullable = false, length = 100)
    private String nombreProveedor;

    @Column(nullable = false, length = 100)
    private String telefonoProveedor;

    @Column(nullable = false, length = 100)
    private String correoProveedor;

    @Column(nullable = false, length = 100)
    private String direccionProveedor;

    @Column(nullable = false, unique=true, length = 15)
    private String rutProveedor;

    @Column(nullable = false, length = 100)
    private String productoProveedor;

    @OneToMany(mappedBy = "proveedor")
    private List<SucursalProveedor> sucursalProveedores;

}

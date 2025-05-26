package sucursal.sucursal.model;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sucursal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// Assuming you want to use auto-generated IDs
    private int idSucursal;

    @Column(nullable = false, length = 100)
    private String nombreSucursal;

    @Column(nullable = false, length = 100)
    private String direccionSucursal;

    @Column(nullable = false, length = 250)
    private String politicasLocales;

    @Column(nullable = false)
    private LocalTime horarioEntrada = LocalTime.of(8, 30);

    @Column(nullable = false)
    private LocalTime horarioSalida = LocalTime.of(17, 30);

    @Column(nullable = false, length = 25)
    private String telefonoSucursal;

    @Column(nullable = false, length = 25)
    private int codigoPostalSucursal;

    @Column(nullable = false, length = 25)
    private String ciudadSucursal;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<SucursalProveedor> sucursalProveedores;
}

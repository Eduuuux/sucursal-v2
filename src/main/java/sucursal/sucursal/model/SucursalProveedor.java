package sucursal.sucursal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "sucursal_proveedor")
@Data
public class SucursalProveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idSucursal", nullable = false)
    @JsonIgnore
    private Sucursal sucursal;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private java.time.LocalDateTime fechaContrato = java.time.LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "idProveedor", nullable = false)
    @JsonIgnore
    private Proveedor proveedor;
}
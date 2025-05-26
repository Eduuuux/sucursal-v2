package sucursal.sucursal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "personal")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private int idPersonal;
    
    @Column(nullable = false, length = 100, unique=true)
    private String rutPersonal;

    @Column(nullable = false, length = 100)
    private String nombrePersonal;

    @Column(nullable = false, length = 100)
    private String apellidoPersonal;

    @Column(nullable = false, length = 25)
    private String telefonoPersonal;

    @Column(nullable = false, length = 100)
    private String correoPersonal;

    @ManyToOne
    @JoinColumn(name = "idSucursal", nullable = false)
    @JsonBackReference
    private Sucursal sucursal;

}

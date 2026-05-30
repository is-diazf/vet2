package cl.franco.mascotas.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "mascotas")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min= 2, max= 100, message = "Debetener un minimo de 2 hasta un maximo de 100 caracteres.")
    private String nombre;

    @NotBlank(message = "La raza es obligatoria.")
    @Size(min= 2, max= 25, message = "Debetener un minimo de 2 hasta un maximo de 25 caracteres. ")
    private String raza;

    @NotNull(message = "Los años son obligatorios.")
    @Past(message = "Debetener un minimo de 5 caracteres. ")
    private LocalDate fechaNacimientoMascota;
}

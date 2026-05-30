package cl.franco.mascotas.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class MascotaResponseDTO {

    private long id;

    private String nombre;

    private String raza;

    private LocalDate fechaNacimientoMascota;

}

package cl.franco.mascotas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import cl.franco.mascotas.model.Mascota;



public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    Optional<Mascota> findByRaza( String raza);

}

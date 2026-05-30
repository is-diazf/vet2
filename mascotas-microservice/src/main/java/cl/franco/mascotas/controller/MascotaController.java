package cl.franco.mascotas.controller;

import cl.franco.mascotas.dto.MascotaResponseDTO;
import cl.franco.mascotas.model.Mascota;
import cl.franco.mascotas.service.MascotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    //Traer a las mascotas
    @GetMapping
    public ResponseEntity<List<MascotaResponseDTO>> listarMascotas(){
        List<MascotaResponseDTO> mascotas = mascotaService.obtenerTodos();
        return ResponseEntity.ok(mascotas);
    }

    //traer el id de la mascota por medio del feign client
    @GetMapping("/{id}")
    public ResponseEntity<MascotaResponseDTO> traerMascota(@PathVariable Long id){
        MascotaResponseDTO mascota = mascotaService.obtenerPorId(id);
        return ResponseEntity.ok(mascota);
    }

    //Añadir una nueva mascota
    @PostMapping
    public ResponseEntity<MascotaResponseDTO> guardarMascota(@RequestBody Mascota mascota){
        MascotaResponseDTO nuevaMascota = mascotaService.almacenar(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota); 
    }

    //Actualizar una nueva mascota 
    @PutMapping ("/{id}")
    public ResponseEntity<MascotaResponseDTO> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota){
        MascotaResponseDTO mascotaActualizada = mascotaService.actualizar(id, mascota);
        return ResponseEntity.ok(mascotaActualizada);
    }

    //Eliminar mascota
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota (@PathVariable Long id){
        mascotaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }




}

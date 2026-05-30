package cl.franco.mascotas.service;

import cl.franco.mascotas.dto.MascotaResponseDTO;
import cl.franco.mascotas.model.Mascota;
import cl.franco.mascotas.repository.MascotaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    
    public MascotaResponseDTO obtenerPorId (Long id){
        Mascota mascota = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("La mascota no se encontro."));

        return mapearADto(mascota);
    }

    public List<MascotaResponseDTO> obtenerTodos(){
        List<Mascota> mascotas = mascotaRepository.findAll();
        return mascotas.stream()
            .map(this :: mapearADto)
            .collect(Collectors.toList());
    }

    public MascotaResponseDTO almacenar (Mascota mascota){
        Mascota MascotaAlmacenada = mascotaRepository.save(mascota);
        return mapearADto(MascotaAlmacenada);
    }

    public MascotaResponseDTO actualizar (Long id, Mascota detallesMascota){
        Mascota mascotaExistente = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mascota no encontrada con el id: " + id));

        mascotaExistente.setNombre(detallesMascota.getNombre());
        mascotaExistente.setRaza(detallesMascota.getRaza());
        mascotaExistente.setFechaNacimientoMascota(detallesMascota.getFechaNacimientoMascota());
        
        Mascota mascotaActualizada = mascotaRepository.save(mascotaExistente);
        return mapearADto(mascotaActualizada);
    }

    public void eliminar (Long id){
        Mascota mascota = mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("No esta la mascota con el id: " + id));
        mascotaRepository.delete(mascota);
    }

    private MascotaResponseDTO mapearADto(Mascota mascota){
        MascotaResponseDTO dto = new MascotaResponseDTO();
        dto.setId(mascota.getId());
        dto.setNombre(mascota.getNombre());
        dto.setRaza(mascota.getRaza());
        dto.setFechaNacimientoMascota(mascota.getFechaNacimientoMascota());
        
        return dto;
    }









}

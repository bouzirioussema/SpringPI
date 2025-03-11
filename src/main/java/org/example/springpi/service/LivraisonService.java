package org.example.springpi.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.springpi.dto.LivraisonDTO;
import org.example.springpi.entity.Livraison;
import org.example.springpi.entity.Livreur;
import org.example.springpi.entity.StatusLivraison;
import org.example.springpi.entity.TypeLivraison;
import org.example.springpi.mapper.LivraisonMapper;
import org.example.springpi.repository.LivraisonRepository;
import org.example.springpi.repository.LivreurRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivraisonService implements ILivraisonService {

    private final LivraisonRepository livraisonRepository;
    private final LivreurRepository livreurRepository;

    public LivraisonService(LivraisonRepository livraisonRepository, LivreurRepository livreurRepository) {
        this.livraisonRepository = livraisonRepository;
        this.livreurRepository = livreurRepository;
    }

    @Override
    public LivraisonDTO addLivraison(LivraisonDTO livraisonDTO) {
        Livraison livraison = LivraisonMapper.toEntity(livraisonDTO);

        // Vérifier si un livreur est spécifié
        if (livraisonDTO.getLivreur() != null && livraisonDTO.getLivreur().getId() != null) {
            Livreur livreur = livreurRepository.findById(livraisonDTO.getLivreur().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Livreur introuvable avec l'ID: " + livraisonDTO.getLivreur().getId()));
            livraison.setLivreur(livreur);
        }

        livraison = livraisonRepository.save(livraison);
        return LivraisonMapper.toDTO(livraison);
    }

    @Override
    public LivraisonDTO getLivraisonById(Long id) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livraison introuvable avec ID: " + id));
        return LivraisonMapper.toDTO(livraison);
    }

    @Override
    public List<LivraisonDTO> getAllLivraisons() {
        return livraisonRepository.findAll().stream()
                .map(LivraisonMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LivraisonDTO updateLivraison(Long id, LivraisonDTO livraisonDTO) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Livraison introuvable avec ID: " + id));

        livraison.setDateLivraison(livraisonDTO.getDateLivraison());

        // Conversion des enums depuis String
        if (livraisonDTO.getStatusLivraison() != null) {
            livraison.setStatusLivraison(StatusLivraison.valueOf(livraisonDTO.getStatusLivraison()));
        }

        if (livraisonDTO.getTypeLivraison() != null) {
            livraison.setTypeLivraison(TypeLivraison.valueOf(livraisonDTO.getTypeLivraison()));
        }

        // Mise à jour du livreur si fourni
        if (livraisonDTO.getLivreur() != null && livraisonDTO.getLivreur().getId() != null) {
            Livreur livreur = livreurRepository.findById(livraisonDTO.getLivreur().getId())
                    .orElseThrow(() -> new EntityNotFoundException("Livreur introuvable avec l'ID: " + livraisonDTO.getLivreur().getId()));
            livraison.setLivreur(livreur);
        }

        livraison = livraisonRepository.save(livraison);
        return LivraisonMapper.toDTO(livraison);
    }

    @Override
    public void deleteLivraison(Long id) {
        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livraison introuvable avec ID: " + id));
        livraisonRepository.delete(livraison);
    }

}

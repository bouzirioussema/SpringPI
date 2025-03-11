package org.example.springpi.mapper;

import org.example.springpi.dto.LivraisonDTO;
import org.example.springpi.dto.LivreurDTO;
import org.example.springpi.entity.Livraison;
import org.example.springpi.entity.Livreur;
import org.example.springpi.entity.StatusLivraison;
import org.example.springpi.entity.TypeLivraison;

public class LivraisonMapper {

    public static LivraisonDTO toDTO(Livraison livraison) {
        LivraisonDTO dto = new LivraisonDTO();
        dto.setId(livraison.getId());
        dto.setDateLivraison(livraison.getDateLivraison());

        // Convertir StatusLivraison Enum → String
        if (livraison.getStatusLivraison() != null) {
            dto.setStatusLivraison(livraison.getStatusLivraison().name());
        }

        // Convertir TypeLivraison Enum → String
        if (livraison.getTypeLivraison() != null) {
            dto.setTypeLivraison(livraison.getTypeLivraison().name());
        }

        if (livraison.getLivreur() != null) {
            LivreurDTO livreurDTO = new LivreurDTO();
            livreurDTO.setId(livraison.getLivreur().getId());
            livreurDTO.setNom(livraison.getLivreur().getNom());
            livreurDTO.setEmail(livraison.getLivreur().getEmail());
            livreurDTO.setTelephone(livraison.getLivreur().getTelephone());
            livreurDTO.setVehicule(livraison.getLivreur().getVehicule());
            dto.setLivreur(livreurDTO);
        }

        return dto;
    }

    public static Livraison toEntity(LivraisonDTO dto) {
        Livraison livraison = new Livraison();
        livraison.setId(dto.getId());
        livraison.setDateLivraison(dto.getDateLivraison());

        // Convertir StatusLivraison String → Enum
        if (dto.getStatusLivraison() != null) {
            livraison.setStatusLivraison(StatusLivraison.valueOf(dto.getStatusLivraison()));
        }

        // Convertir TypeLivraison String → Enum
        if (dto.getTypeLivraison() != null) {
            livraison.setTypeLivraison(TypeLivraison.valueOf(dto.getTypeLivraison()));
        }

        if (dto.getLivreur() != null) {
            Livreur livreur = new Livreur();
            livreur.setId(dto.getLivreur().getId());
            livreur.setNom(dto.getLivreur().getNom());
            livreur.setEmail(dto.getLivreur().getEmail());
            livreur.setTelephone(dto.getLivreur().getTelephone());
            livreur.setVehicule(dto.getLivreur().getVehicule());
            livraison.setLivreur(livreur);
        }

        return livraison;
    }
}

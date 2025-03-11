package org.example.springpi.mapper;

import org.example.springpi.dto.LivreurDTO;
import org.example.springpi.entity.Livreur;

public class LivreurMapper {

    public static LivreurDTO toDTO(Livreur livreur) {
        if (livreur == null) return null;

        return new LivreurDTO(
                livreur.getId(),
                livreur.getNom(),
                livreur.getEmail(),
                livreur.getTelephone(),
                livreur.getVehicule() // Ajout du champ vehicule
        );
    }

    public static Livreur toEntity(LivreurDTO livreurDTO) {
        if (livreurDTO == null) return null;

        Livreur livreur = new Livreur();
        livreur.setId(livreurDTO.getId());
        livreur.setNom(livreurDTO.getNom());
        livreur.setEmail(livreurDTO.getEmail());
        livreur.setTelephone(livreurDTO.getTelephone());
        livreur.setVehicule(livreurDTO.getVehicule()); // Ajout du champ vehicule

        return livreur;
    }
}

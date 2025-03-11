package org.example.springpi.service;

import org.example.springpi.dto.LivraisonDTO;

import java.util.List;

public interface ILivraisonService {
    LivraisonDTO addLivraison(LivraisonDTO livraisonDTO);
    LivraisonDTO getLivraisonById(Long id);
    List<LivraisonDTO> getAllLivraisons();
    LivraisonDTO updateLivraison(Long id, LivraisonDTO livraisonDTO);
    void deleteLivraison(Long id);
}

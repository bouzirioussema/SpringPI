package org.example.springpi.controller;

import org.example.springpi.dto.LivraisonDTO;
import org.example.springpi.entity.Livraison;
import org.example.springpi.entity.Livreur;
import org.example.springpi.mapper.LivraisonMapper;
import org.example.springpi.service.ILivraisonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {

    private final ILivraisonService livraisonService;

    public LivraisonController(ILivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    // Exemple de méthode POST
    @PostMapping("/create")
    public ResponseEntity<LivraisonDTO> createLivraison(@RequestBody LivraisonDTO livraisonDTO) {
        LivraisonDTO createdLivraison = livraisonService.addLivraison(livraisonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLivraison);
    }


    @GetMapping("/{id}")
    public ResponseEntity<LivraisonDTO> getLivraison(@PathVariable Long id) {
        LivraisonDTO livraisonDTO = livraisonService.getLivraisonById(id);
        return ResponseEntity.ok(livraisonDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<LivraisonDTO>> getAllLivraisons() {
        List<LivraisonDTO> livraisons = livraisonService.getAllLivraisons();
        return ResponseEntity.ok(livraisons);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivraisonDTO> updateLivraison(@PathVariable Long id, @RequestBody LivraisonDTO livraisonDTO) {
        LivraisonDTO updatedLivraison = livraisonService.updateLivraison(id, livraisonDTO);
        return ResponseEntity.ok(updatedLivraison);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteLivraison(@PathVariable Long id) {
        livraisonService.deleteLivraison(id);
        return ResponseEntity.ok(Map.of("message", "Livraison supprimée avec succès", "id", id.toString()));
    }
}

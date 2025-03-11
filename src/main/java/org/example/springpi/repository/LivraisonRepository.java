package org.example.springpi.repository;

import org.example.springpi.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    List<Livraison> findByStatusLivraison(String status);

}

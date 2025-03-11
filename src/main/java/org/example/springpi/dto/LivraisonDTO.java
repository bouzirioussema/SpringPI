package org.example.springpi.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class LivraisonDTO {
    private Long id;
    private LocalDate dateLivraison;
    private String statusLivraison;
    private String typeLivraison;
    private LivreurDTO livreur;
}

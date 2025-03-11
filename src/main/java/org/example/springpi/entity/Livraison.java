package org.example.springpi.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateLivraison;

    @Enumerated(EnumType.STRING)
    private StatusLivraison statusLivraison;

    @Enumerated(EnumType.STRING)
    private TypeLivraison typeLivraison;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "livreur_id", nullable = false)
    private Livreur livreur;

}



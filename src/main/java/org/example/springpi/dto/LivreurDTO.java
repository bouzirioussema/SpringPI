package org.example.springpi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivreurDTO {
    private Long id;
    private String nom;
    private String email;
    private String telephone;
    private String vehicule;

}

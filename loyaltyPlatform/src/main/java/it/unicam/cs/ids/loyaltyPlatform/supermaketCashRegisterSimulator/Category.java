package it.unicam.cs.ids.loyaltyPlatform.supermaketCashRegisterSimulator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
<<<<<<< HEAD
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String category;
=======


>>>>>>> df3a7d2 (First touch down of the Category class for the supermarket class)
}

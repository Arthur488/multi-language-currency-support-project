package com.myproject.products.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double price;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "description_en")
    private String descriptionEn;

    @Column(name = "description_ru")
    private String descriptionRu;

    public Product(String nameEn, String nameRu, String descriptionEn, String descriptionRu) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.descriptionEn = descriptionEn;
        this.descriptionRu = descriptionRu;
    }

}

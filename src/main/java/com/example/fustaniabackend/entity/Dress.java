
package com.example.fustaniabackend.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "dresses")
@Data
public class Dress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String designer;

   @Column(name="image_url", nullable = false)
    private String imageUrl;

     @Column(nullable = false)
    private String color;

 @Column(nullable = false)
    private String size;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

  
}
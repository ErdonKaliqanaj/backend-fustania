package com.fustania.backendfustania.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
   public enum Role {
	   BUYER, SELLER
   }
   public enum Country{
	   KOSOVA,ALBANIA,MACEDONIA
   }
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    
   private Long id;
   
   @NotBlank
   private String name;
   
   @NotBlank
   private String surname;
   
   @Email
   @Column(unique = true)
   private String email;
   
   @NotBlank
   private String password;
   
   @Enumerated(EnumType.STRING)
   private Country country;
   
   @Enumerated(EnumType.STRING)
   private Role role;
}

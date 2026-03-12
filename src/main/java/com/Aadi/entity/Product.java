package com.Aadi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
@Entity
@Data
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is Required")
    private String name;

   @NotNull(message = "price is required")
   @Positive(message = "Price will be Positve")
    private Double price;

    @NotNull(message = "quantity is Required")
    @Positive(message = "quantity will be positve")
    private Integer qty;

   @NotBlank(message = "category is required")
    private String category;
}
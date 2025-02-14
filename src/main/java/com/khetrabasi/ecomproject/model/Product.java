package com.khetrabasi.ecomproject.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private int price;
    private String category;

//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yy")
    private Date releaseDate;
    private boolean available;
    private int quantity;

    private String imageName;
    private String imageType;
    @Lob
    private byte[] ImageData;
}
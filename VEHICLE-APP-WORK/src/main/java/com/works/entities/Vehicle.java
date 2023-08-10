package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vid;
    
    @NotEmpty
    @NotNull
    private String plate;

    private String chassisNumber;
    private String label;

    @NotEmpty
    @NotNull
    private String brand;

    @NotEmpty
    @NotNull
    private String model;

    @NotEmpty
    @NotNull
    private String modelYear;

    private Long uid;


}

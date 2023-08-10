package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class VehicleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String groupName;

    @ManyToMany
    private List<Vehicle> vehicles;
    @ManyToMany
    private  List<Customer> customers;


}
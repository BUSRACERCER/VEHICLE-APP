package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VehicleGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    private String groupName;

}
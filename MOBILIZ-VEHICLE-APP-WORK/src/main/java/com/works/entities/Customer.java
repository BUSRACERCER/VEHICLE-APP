package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String name;
    private String surname;

    @Email
    private String email;
    private String password;


    private Long companyId;
    private String companyName;

    @ManyToMany
    private List<Role> roles;

}

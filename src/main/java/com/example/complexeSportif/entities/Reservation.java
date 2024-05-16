package com.example.complexeSportif.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Reservation {
    @Id
    private Integer id;
    private String description;
    private Date dateRes;

}

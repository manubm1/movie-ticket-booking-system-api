package com.example.mtb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
public class TheaterOwner extends UserDetails{
    @OneToMany
    private List<Theater> theater;



}

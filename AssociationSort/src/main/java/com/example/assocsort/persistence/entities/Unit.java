package com.example.assocsort.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Unit {
  
    /* E.g. 'Kg' */
    @Id
    private String code;
    
    /* E.g., 'Kilogramm' */
    private String fullName;

}

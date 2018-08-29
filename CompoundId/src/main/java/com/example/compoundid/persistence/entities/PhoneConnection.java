package com.example.compoundid.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.example.compoundid.persistence.CodeId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@Entity
@IdClass(CodeId.class)
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class PhoneConnection {
    @Id private Long countryCode;
    @Id private Long providerCode;
    
    private Long number;
    private String owner;
}

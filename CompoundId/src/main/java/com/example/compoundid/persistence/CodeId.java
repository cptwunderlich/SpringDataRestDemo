package com.example.compoundid.persistence;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class CodeId implements Serializable {
    private static final long serialVersionUID = 6872609912487031006L;
  
    private Long countryCode;
    private Long providerCode;
}

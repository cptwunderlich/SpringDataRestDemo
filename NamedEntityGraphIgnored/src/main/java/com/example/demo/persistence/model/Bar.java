package com.example.demo.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = {"value"})
public class Bar {
  @Id @GeneratedValue
  private Long id;
  
  private String value;
  
  @Version
  private Long version;
}

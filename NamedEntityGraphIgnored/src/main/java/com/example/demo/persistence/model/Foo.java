package com.example.demo.persistence.model;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@NamedEntityGraph(name = "Foo.full", includeAllAttributes = true)
@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(of = {"name"})
public class Foo {
  @Id @GeneratedValue
  private Long id;
  
  private String name;
  
  @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
  @NonNull
  private Bar bar;
  
  @Version
  private Long version;
}

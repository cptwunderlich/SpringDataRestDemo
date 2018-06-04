package com.example.demo.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.persistence.model.Foo;

@RestResource
public interface FooRepository extends JpaRepository<Foo, Long> {
  
  @EntityGraph(value = "Foo.full", type = EntityGraphType.LOAD)
  @Override
  List<Foo> findAll();
}

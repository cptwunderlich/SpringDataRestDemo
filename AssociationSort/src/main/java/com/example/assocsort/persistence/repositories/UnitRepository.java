package com.example.assocsort.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.assocsort.persistence.entities.Unit;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@RepositoryRestResource
public interface UnitRepository extends JpaRepository<Unit, String> {

}

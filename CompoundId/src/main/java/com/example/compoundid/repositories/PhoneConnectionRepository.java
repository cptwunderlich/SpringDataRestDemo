package com.example.compoundid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.compoundid.persistence.CodeId;
import com.example.compoundid.persistence.entities.PhoneConnection;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@RepositoryRestResource
public interface PhoneConnectionRepository extends JpaRepository<PhoneConnection, CodeId> {

}

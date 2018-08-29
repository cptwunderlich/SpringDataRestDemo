package com.example.assocsort.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.assocsort.persistence.entities.Article;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@RepositoryRestResource
public interface ArticleRepository extends JpaRepository<Article, Long>, QuerydslPredicateExecutor<Article> {

}

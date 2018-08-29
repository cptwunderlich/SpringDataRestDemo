package com.example.assocsort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.assocsort.persistence.entities.Article;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AssocsortApplicationTests {
    @Autowired
    private EntityManager em;
  
  	@Test
  	public void contextLoads() {
  	}
  	
  	@Test
  	public void sortByAssociationId() {
  	    List<Article> articles = em.createQuery("SELECT a FROM Article a ORDER BY unit.code DESC", Article.class) //
  	        .getResultList();
  	    
  	    assertThat(articles).isSortedAccordingTo( //
  	        (a, b) -> (a.getUnit().getCode().compareTo(b.getUnit().getCode()) * -1) //
  	        );
  	}

    @Test
    public void sortByAssociationProperty() {
        List<Article> articles = em.createQuery("SELECT a FROM Article a ORDER BY unit.fullName DESC", Article.class) //
            .getResultList();
        
        assertThat(articles).isSortedAccordingTo( //
            (a, b) -> (a.getUnit().getFullName().compareTo(b.getUnit().getFullName()) * -1) //
            );
    }
}

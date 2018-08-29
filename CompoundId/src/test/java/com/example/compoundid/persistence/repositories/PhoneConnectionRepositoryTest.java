package com.example.compoundid.persistence.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.compoundid.persistence.CodeId;
import com.example.compoundid.persistence.entities.PhoneConnection;
import com.example.compoundid.repositories.PhoneConnectionRepository;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PhoneConnectionRepositoryTest {
    @Autowired
    private PhoneConnectionRepository repo;
    
    @Test
    public void testAccessWithIdClass() {
        CodeId cid = new CodeId(1L, 9L);
        PhoneConnection pc = new PhoneConnection(1L, 9L, 666L, "Test");
        repo.saveAndFlush(pc);
        
        PhoneConnection retrieved = repo.getOne(cid);
        
        assertEquals(pc, retrieved);
    }
}

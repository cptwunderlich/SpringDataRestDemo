package com.example.compoundid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.example.compoundid.persistence.entities.PhoneConnection;
import com.example.compoundid.repositories.PhoneConnectionRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DbInitializer implements ApplicationRunner {
    private final PhoneConnectionRepository repo;
  
    /*
     * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        repo.save(new PhoneConnection(001L, 123L, 456L, "Test"));
        repo.save(new PhoneConnection(001L, 666L, 987L, "Foobar"));
        repo.save(new PhoneConnection(002L, 123L, 101L, "Baz"));
    }

}

package com.example.demo.persistence.repository;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.persistence.model.Bar;
import com.example.demo.persistence.model.Foo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
@Slf4j
public class FooRepositoryTest {
  @Autowired
  private FooRepository fooRepo;
  
  @Autowired
  private MockMvc mvc;

  @Before
  public void beforeAll() {
    Bar b1 = new Bar();
    b1.setValue("bar1");

    Foo foo = new Foo();
    foo.setName("foo");
    foo.setBar(b1);
    fooRepo.saveAndFlush(foo);
  }
  
  @Test
  public void testFindAll() {
    log.info("Local test");
    List<Foo> foos = fooRepo.findAll();
    assertTrue(foos.size() > 0);
  }
  
  @Test
  public void testRestCollectionResource() throws Exception {
    log.info("REST test");
    MvcResult res = 
      mvc.perform(get("/foos").accept(MediaType.APPLICATION_JSON_UTF8))
          .andExpect(status().isOk())
          .andReturn();
    
    String body = res.getResponse().getContentAsString();
    assertTrue(body != null && !body.isEmpty());
  }
}

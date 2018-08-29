package com.example.assocsort;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.example.assocsort.persistence.entities.Article;
import com.example.assocsort.persistence.entities.Unit;
import com.example.assocsort.persistence.repositories.ArticleRepository;
import com.example.assocsort.persistence.repositories.UnitRepository;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Benjamin Maurer (maurer.benjamin@gmail.com)
 * @since 29.08.2018
 */
@Service
@RequiredArgsConstructor(onConstructor_={@Autowired})
public class DbInitializerRunner implements ApplicationRunner {
    private final UnitRepository unitRepo;
    private final ArticleRepository articleRepo;

    /*
     * @see org.springframework.boot.ApplicationRunner#run(org.springframework.boot.ApplicationArguments)
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Unit kg = new Unit("Kg", "Kilogramm");
        Unit l = new Unit("L", "Litre");
        Unit pc = new Unit("pc", "Piece");
        List<Unit> units = Arrays.asList(kg, l, pc);
        unitRepo.saveAll(units);
        unitRepo.flush();
        
        List<Article> articles = Arrays.asList( //
            new Article(null, "Nuts", kg), //
            new Article(null, "Oats", kg), //
            new Article(null, "Oil", l), //
            new Article(null, "Frozen Pizza", pc) //
        );
        articleRepo.saveAll(articles);
        articleRepo.flush();
    }

}

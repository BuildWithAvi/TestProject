package com.example.db.service;

import com.example.db.entity.Bqrm;
import com.example.db.repository.primary.BqrmRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BqrmService {

    @Autowired
    @Qualifier("primaryEntityManager")
    private EntityManager primaryEntityManager;

    @Autowired
    @Qualifier("secondaryEntityManager")
    private EntityManager secondaryEntityManager;

    @Autowired
    private BqrmRepository bqrmRepository;

    public Optional<Bqrm> findByName(String name) {
        // Query primary database
        Optional<Bqrm> result = queryDatabase(primaryEntityManager, name);
        if (result.isPresent()) {
            return result;
        }

        // Query secondary database
        return queryDatabase(secondaryEntityManager, name);
    }

    private Optional<Bqrm> queryDatabase(EntityManager entityManager, String name) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManager);
        BqrmRepository dynamicRepo = factory.getRepository(BqrmRepository.class);
        return dynamicRepo.findByName(name);
    }
}


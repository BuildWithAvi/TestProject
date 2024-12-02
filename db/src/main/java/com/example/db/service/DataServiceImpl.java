package com.example.db.service;

import com.example.db.dto.DataRequest;
import com.example.db.entity.primary.PrimaryEntity;
import com.example.db.entity.secondary.SecondaryEntity;
import com.example.db.repository.primary.PrimaryRepository;
import com.example.db.repository.secondary.SecondaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    private final PrimaryRepository primaryRepository;
    private final SecondaryRepository secondaryRepository;

    public DataServiceImpl(PrimaryRepository primaryRepository, SecondaryRepository secondaryRepository) {
        this.primaryRepository = primaryRepository;
        this.secondaryRepository = secondaryRepository;
    }

    @Override
    public String saveData(DataRequest request) {
        if (request.getName() != null && !request.getName().isEmpty()) {
            // Save to Primary DB
            PrimaryEntity primaryEntity = new PrimaryEntity(request.getName());
            primaryRepository.save(primaryEntity);
            return "Data saved to Primary DB";
        } else if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            // Save to Secondary DB
            SecondaryEntity secondaryEntity = new SecondaryEntity(request.getDescription());
            secondaryRepository.save(secondaryEntity);
            return "Data saved to Secondary DB";
        } else {
            throw new IllegalArgumentException("Invalid input: Either 'name' or 'description' must be provided.");
        }
    }
}


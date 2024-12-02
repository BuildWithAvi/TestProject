package com.example.db.repository.secondary;

import com.example.db.entity.secondary.SecondaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryRepository extends JpaRepository<SecondaryEntity, Long> {
}
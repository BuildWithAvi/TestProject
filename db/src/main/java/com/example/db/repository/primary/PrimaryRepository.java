package com.example.db.repository.primary;

import com.example.db.entity.primary.PrimaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryRepository extends JpaRepository<PrimaryEntity, Long> {
}
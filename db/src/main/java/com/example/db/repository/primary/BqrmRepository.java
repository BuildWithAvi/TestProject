package com.example.db.repository.primary;

import com.example.db.entity.Bqrm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BqrmRepository extends JpaRepository<Bqrm, Long> {

    Optional<Bqrm> findByName(String name);

}

package com.example.test.demo.dataprovider;

import com.example.test.demo.dataprovider.entity.AutomovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomoveisRepository extends JpaRepository<AutomovelEntity, Long> {
}

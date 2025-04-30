package com.agrihub.impact_assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrihub.impact_assessment.model.OutputModel;

@Repository
public interface OutputRepository extends JpaRepository<OutputModel, Long> {
    // You can add custom queries here, e.g. findByInputModelId(Long id)
}

package com.agrihub.impact_assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agrihub.impact_assessment.model.InputModel;

@Repository
public interface InputRepository extends JpaRepository<InputModel, Long> {
    // You can define custom queries here if needed later
}

package com.brq.ms03.repositories;

import com.brq.ms03.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <ProfessorModel, Integer> {
}

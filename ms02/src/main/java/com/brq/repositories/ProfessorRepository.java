package com.brq.repositories;

import com.brq.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<ProfessorModel, Integer> {

}

package com.brq.exemplo01.repositories;

import com.brq.exemplo01.models.ExemploModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemploRepository extends JpaRepository<ExemploModel, Integer> {
}

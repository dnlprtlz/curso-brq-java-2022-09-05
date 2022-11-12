package com.brq.ms04.repositories;

import com.brq.ms04.models.MessageModel;
import com.brq.ms04.models.USDBRLModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository
        extends JpaRepository<MessageModel, Integer> {
}
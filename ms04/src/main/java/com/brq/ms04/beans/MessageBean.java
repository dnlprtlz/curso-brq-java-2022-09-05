package com.brq.ms04.beans;

import com.brq.ms04.dtos.CotacaoUSDDTO;
import com.brq.ms04.models.MessageModel;
import com.brq.ms04.models.USDBRLModel;
import com.brq.ms04.repositories.MessageRepository;
import com.brq.ms04.repositories.USDBRLRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MessageBean {

  @Autowired
  private MessageRepository repository;


  public MessageModel save(String message){

    final var m = MessageModel
            .builder()
            .message(message)
            .build();

    return repository.save(m);
  }}
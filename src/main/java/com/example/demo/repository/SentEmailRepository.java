package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SentEmail;

@Repository
public interface SentEmailRepository  extends JpaRepository<SentEmail, Integer>{

}

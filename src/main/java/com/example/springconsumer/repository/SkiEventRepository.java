package com.example.springconsumer.repository;

import com.example.springconsumer.model.SkiEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkiEventRepository extends JpaRepository<SkiEvent, String> {
}

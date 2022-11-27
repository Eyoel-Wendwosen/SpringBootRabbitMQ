package com.example.springconsumer.repository;

import com.example.springconsumer.model.Skier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkierService extends JpaRepository<Skier, String> {
    List<Skier> findSkierBySkierId(Integer skierId);
}

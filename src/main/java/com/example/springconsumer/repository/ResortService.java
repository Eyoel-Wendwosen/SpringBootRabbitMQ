package com.example.springconsumer.repository;

import com.example.springconsumer.model.Resort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResortService extends JpaRepository<Resort, String> {
    List<Resort> findResortByResortId(Integer resortId);
}

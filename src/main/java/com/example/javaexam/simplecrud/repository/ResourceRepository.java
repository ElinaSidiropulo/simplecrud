package com.example.javaexam.simplecrud.repository;

import com.example.javaexam.simplecrud.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}

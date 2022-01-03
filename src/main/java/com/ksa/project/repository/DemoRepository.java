package com.ksa.project.repository;

import com.ksa.project.model.Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> {
};

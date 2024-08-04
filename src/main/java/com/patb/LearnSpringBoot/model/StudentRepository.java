package com.patb.LearnSpringBoot.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    
    Student findByEmail(String email);
    
    @Query("SELECT s FROM Student s WHERE s.email LIKE %:domain")
    List<Student> findByDomain(@Param("domain") String domain);
}

package com.redisdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redisdemo.entity.StudentEntity;


@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

}

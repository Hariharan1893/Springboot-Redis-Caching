package com.redisdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.redisdemo.entity.StudentEntity;
import com.redisdemo.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studRepo;
	
	@Cacheable(value = "Student" , key="#id")
	public StudentEntity getById(Long id) {
		return studRepo.findById(id).orElse(null);
	}
	
	@CachePut(value = "Student" , key = "#stud.id")
	public StudentEntity addStud(StudentEntity stud) {
		return studRepo.save(stud);
	}
	
	@CacheEvict(value = "Student" , key="#id")
	public void deleteStud(Long id) {
		studRepo.deleteById(id);
	}

}

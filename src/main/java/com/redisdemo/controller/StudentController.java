package com.redisdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redisdemo.entity.StudentEntity;
import com.redisdemo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studService;
	


	@PostMapping
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity stud) {
		StudentEntity savedStud = studService.addStud(stud);

		return ResponseEntity.ok(savedStud);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {

		return ResponseEntity.of(Optional.ofNullable(studService.getById(id)));

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

		StudentEntity delStud = studService.getById(id);

		if (delStud == null)
			return ResponseEntity.notFound().build();

		studService.deleteStud(id);

		return ResponseEntity.noContent().build();
	}

}

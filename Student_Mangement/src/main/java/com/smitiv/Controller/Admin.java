package com.smitiv.Controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.smitiv.Model.Student;
import com.smitiv.Repository.StudentRepository;

@RequestMapping("/api/v1")
@RestController
public class Admin {
	
	
	@Autowired
	private StudentRepository res;
	
	/**
	   * Get all Student list.
	   *
	   * @return the list
	   */
	  @GetMapping("/users")
	  public List<Student> getAllUsers() {
	    return res.findAll();
	  }
	  
	  /**
	   * Create user user.
	   *
	   * @param user the user
	   * @return the user
	   */
	 
	  @PostMapping("/Student")
	  public Student createUser(@Valid @RequestBody Student user) {
	    return res.save(user);
	  }

	  
	  /**
	   * Update user response entity.
	   *
	   * @param userId the user id
	   * @param userDetails the user details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	
	  
	  @PutMapping("/Student/{id}")
	  public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long userId, @Valid @RequestBody Student studentDetails)
	      throws ResourceAccessException {
	    Student student =
	        res .findById(userId)
	            .orElseThrow(() -> new ResourceAccessException("User not found on :: " + userId));
	    
	    student.setEmail(studentDetails.getEmail());
	    student.setStudent_name(studentDetails.getStudent_name());
	    student.setAdress(studentDetails.getAdress());
	  
	    final Student updatedUser = res.save(student);
	    return ResponseEntity.ok(updatedUser);
	  }

	  

	
	
	

}

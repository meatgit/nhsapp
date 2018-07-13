package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NHSController {

	@Autowired
	private ILocalRepository repository;
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot HAHAHHA!";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
    public void save(@RequestBody Student student) {
    	//repository.deleteAll();
    	repository.save(student);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    public void delete(@RequestBody String id) {
    	System.out.println("Delete id "+id);
    	repository.deleteById(id);
    }
    
    @RequestMapping("/getall") 
    public List<Student> getAllStudents() {
    	System.out.println(repository.findAll().size());
    	return repository.findAll();
    }
}

package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("Student not found", false));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        if(student.getNames()!=null || student.getGender()!=null || student.getEmail()!=null) {
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("All fields are required", false));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestBody Student student){
        Optional<Student> studentData = studentRepository.findById(id);
        if(studentData.isPresent()){
            Student _student = studentData.get();
            _student.setEmail(student.getEmail());
            _student.setNames(student.getNames());
            _student.setGender(student.getGender());
            return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(_student));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("Student not found", false));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new APIResponse("Deleted Successfully", true));
    }
}

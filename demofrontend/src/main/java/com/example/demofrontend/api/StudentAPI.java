package com.example.demofrontend.api;

import com.example.demofrontend.models.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentAPI {
    @GetMapping("/all")
    public String getAllStudents(Model model){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<Student> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<List> studentResponse = restTemplate.exchange("http://localhost:8080/api/students/all", HttpMethod.GET, requestEntity, List.class);

        List<Student> studentsList = studentResponse.getBody();
        model.addAttribute("students", studentsList);
        return "students";
    }
    @GetMapping("/infos/{id}")
    public String getOneStudent(@PathVariable Long id, Model model){
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Student> requestEntity = new HttpEntity<>(null, headers);
        ResponseEntity<Student> studentResponse = restTemplate.exchange("http://localhost:8080/api/students/find/"+id, HttpMethod.GET, requestEntity, Student.class);

        Student student = studentResponse.getBody();
        model.addAttribute("student", student);
        return "singlestudent";
    }
}

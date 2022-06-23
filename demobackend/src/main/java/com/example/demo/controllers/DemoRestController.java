package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/demo")
public class DemoRestController {
    List<String> names = new ArrayList<>();
    @GetMapping("/say-hello")
    public List<String> sayHello(){
        return names;
    }
    @PostMapping("/add-names")
    public String postName(@RequestBody String name){
        System.out.println(name);
        names.add(name);
        return name;
    }
}

package com.example.controller;

import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private userService userService;

    @PostMapping("/registerUser")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> saveForm(@RequestBody User user){
        try {
            this.userService.saveForm(user);
            return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully...");
        }catch (CustomException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/getUsers")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<User>> getAll(){
        try {
            List<User> list = this.userService.getAll();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

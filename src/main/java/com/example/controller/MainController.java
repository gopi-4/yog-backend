package com.example.controller;

import com.example.entity.Response;
import com.example.entity.User;
import com.example.exception.CustomException;
import com.example.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private userService userService;

    @PostMapping("/registerUser")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Response> saveForm(@RequestBody User user){
        try {
            User user1 = this.userService.saveForm(user);
            return ResponseEntity.status(HttpStatus.OK).body(new Response("Successfully Registered.", user1));
        }catch (CustomException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(ex.getMessage(), null));
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response(e.getMessage(), null));
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

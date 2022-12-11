package com.example.service;

import com.example.dao.UserRepository;
import com.example.entity.User;
import com.example.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    public User saveForm(User user) throws CustomException {
        String email = user.getEmail();
        User user1 = this.userRepository.getUserByEmail(email);

        if(user1!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(user1.getRegistration_date());
            int month1 = cal.get(Calendar.MONTH);
            cal.setTime(new java.sql.Date(System.currentTimeMillis()));
            int month2 = cal.get(Calendar.MONTH);
            if(month1==month2) throw new CustomException("User already registered");
            else this.userRepository.delete(user1);
        }
        user.setPayment_status(CompletePayment(user.getEmail()));
        System.out.println(user.getPayment_status());
        if(!user.getPayment_status()) throw new CustomException("Payment Fail!!!");
        user.setRegistration_date(new java.sql.Date(System.currentTimeMillis()));
        return this.userRepository.save(user);
    }

    private boolean CompletePayment(String email){
        return !email.equals("test@gmail.com");
    }

    public List<User> getAll() throws CustomException {
        try {
            return this.userRepository.getAllUsers();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new CustomException("Error Fetching Users..");
        }
    }
}

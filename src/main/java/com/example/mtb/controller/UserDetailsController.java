package com.example.mtb.controller;

import com.example.mtb.entity.UserDetails;
import com.example.mtb.service.UserService;
import com.example.mtb.responsebuilder.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class UserDetailsController {

    private final UserService userService;
   @PostMapping("/registration")
    ResponseEntity<ResponseStructure<UserDetails>> userRegistration(@RequestBody UserDetails user){
        UserDetails users = userService.userRegistration(user);

        ResponseStructure<UserDetails> resp = new ResponseStructure<>();
        resp.setStatusCode(HttpStatus.CREATED.value());
        resp.setMessage(" User registred Successfully");
        resp.setData(users);
        return new  ResponseEntity<ResponseStructure<UserDetails>>(resp,HttpStatus.CREATED);
    }



}

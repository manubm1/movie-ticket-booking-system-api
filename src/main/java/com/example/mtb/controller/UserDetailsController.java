package com.example.mtb.controller;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.responsebuilder.ResponseBuilder;
import com.example.mtb.service.UserService;
import com.example.mtb.responsebuilder.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserDetailsController {

    private final UserService userService;

    @Autowired
    private final ResponseBuilder responseBuilder;

   @PostMapping("/registration")
    ResponseEntity<ResponseStructure<UserResponse>> userRegistration(@RequestBody UserRegistrationRequest users){
        UserResponse user = userService.userRegistration(users);
         return responseBuilder.success(HttpStatus.CREATED, " registered successfully to Booking platform", user);

    }
   @PatchMapping ("/email")
    ResponseEntity<ResponseStructure<UserResponse>> profileUpdate(@RequestParam String email, @RequestBody UserRequest request){
       UserResponse details = userService.profileUpdate(email,request);

       return responseBuilder.success(HttpStatus.ACCEPTED,"Profile updated Successfully",details);
    }



}

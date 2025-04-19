package com.example.mtb.service.useripl;

import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserRegistrationException;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;


    @Override
    public UserDetails userRegistration(UserDetails user) {
       if(userDetailsRepository.existsByEmail(user.getEmail())) {
           throw new UserRegistrationException(" User already exists");
       }
         else
           return userDetailsRepository.save(user);
       }
    }


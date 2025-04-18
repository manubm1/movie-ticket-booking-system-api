package com.example.mtb.service.serviceimpl;

import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.UserRegistrationException;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

      final UserDetailsRepository userRepository;

    @Override
    public UserDetails userRegistration(UserDetails user) {
        if(userRepository.existsByEmail(user.getEmail())) {
             throw new UserRegistrationException(" This email already Existing in data Base");

        }else
           return  userRepository.save(user);
    }
}

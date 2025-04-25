package com.example.mtb.service.useripl;

import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.exception.UserNotFoundException;
import com.example.mtb.exception.UserRegistrationException;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@AllArgsConstructor
public class UserImpl implements UserService {

    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserResponse userRegistration(UserRegistrationRequest users) {
       if(userDetailsRepository.existsByEmail(users.email())) {
           throw new UserRegistrationException(" User already exists");
       }
         else {

           if (users.userRole() == UserRole.USER) {
               UserDetails userDetails = new User();
               userDetails.setUsername(users.username());
               userDetails.setEmail(users.email());
               userDetails.setUserRole(users.userRole());
               userDetails.setPassword(users.password());
               userDetails.setPhoneNumber(users.phoneNumber());
               userDetails.setDateOfBirth(users.dateOfBirth());


              userDetailsRepository.save(userDetails);
               return new UserResponse(userDetails.getUserId(),userDetails.getUsername(),userDetails.getEmail(),userDetails.getPhoneNumber(),userDetails.getUserRole(),userDetails.getDateOfBirth(), userDetails.getCreateAt(), userDetails.getUpdateAt());

           } else {
               UserDetails userDetails=new TheaterOwner();

               userDetails.setUsername(users.username());
               userDetails.setEmail(users.email());
               userDetails.setUserRole(users.userRole());
               userDetails.setPassword(users.password());
               userDetails.setPhoneNumber(users.phoneNumber());
               userDetails.setDateOfBirth(users.dateOfBirth());
               userDetailsRepository.save(userDetails);
               return new UserResponse(userDetails.getUserId(),userDetails.getUsername(),userDetails.getEmail(),userDetails.getPhoneNumber(),userDetails.getUserRole(),userDetails.getDateOfBirth(),userDetails.getCreateAt(),userDetails.getUpdateAt());
           }
       }
    }

    @Override
    public UserResponse profileUpdate(String email, UserRequest request) {
        Optional<UserDetails> optionalUser = Optional.ofNullable(userDetailsRepository.findByEmail(email));

        if(optionalUser.isPresent()){
            UserDetails details = optionalUser.get();
            if(request.username()!=null) {
                details.setUsername(request.username());
            }
            if(request.dateOfBirth()!=null) {
                details.setDateOfBirth(request.dateOfBirth());
            }
            if(request.phoneNumber()!=null) {
                details.setPhoneNumber(request.phoneNumber());
            }

             userDetailsRepository.save(details);
            return new UserResponse(details.getUserId(),details.getUsername(),details.getEmail(),details.getPhoneNumber(),details.getUserRole(),details.getDateOfBirth(), details.getCreateAt(), details.getUpdateAt());

        }else
            throw new UserNotFoundException("User not found ");
    }

}


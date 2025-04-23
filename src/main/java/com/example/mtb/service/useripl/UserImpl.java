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

import java.time.LocalDate;
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
    public UserDetails profileUpdate(String email, UserRequest request) {

        UserDetails details = userDetailsRepository.findByEmail(email);


         if(details !=null){
             UserDetails userdetails = new UserDetails();

//             if(request.username()==null){
//                 userdetails.setUsername(details.getUsername());
//             }else {
//                 userdetails.setUserId(request.username());
//             }
//
//             if(request.phoneNumber()==null){
//                 userdetails.setPhoneNumber(details.getPhoneNumber());
//             }else{
//                 userdetails.setPhoneNumber(request.phoneNumber());
//             }
//
//             if(request.dateOfBirth()==null){
//                 userdetails.setDateOfBirth(details.getDateOfBirth());
//             }else {
//                 userdetails.setUsername(request.username());
//             }
             userdetails.setPhoneNumber(request.phoneNumber());
             userdetails.setUsername(request.username());
             userdetails.setUserId(request.username());
             userdetails.setPassword(details.getPassword());
             userdetails.setUserRole(details.getUserRole());
             userdetails.setEmail(details.getEmail());
             userdetails.setCreateAt(details.getCreateAt());
             userdetails.setUpdateAt(details.getUpdateAt());
             userdetails.setUserId(details.getUserId());

             return userDetailsRepository.save(userdetails);
         }else

             throw new UserNotFoundException(" User not exists ");
    }
}


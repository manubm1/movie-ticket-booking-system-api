package com.example.mtb.responsebuilder;

<<<<<<< HEAD
import com.example.mtb.exception.UserNotFoundExcception;
=======
import com.example.mtb.exception.UserNotFoundException;
>>>>>>> master
import com.example.mtb.exception.UserRegistrationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handlerUserRegistration(UserRegistrationException ex){

        ErrorStructure<String> error = new ErrorStructure<String>();
        error.setErorCode(HttpStatus.FOUND.value());
        error.setErrorMessage(ex.getMessage());
        error.setError(" User already exist");

        return new ResponseEntity<ErrorStructure<String>>(error,HttpStatus.FOUND);
    }
<<<<<<< HEAD


    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handlerUserNotFound(UserNotFoundExcception ex){

        ErrorStructure<String> error = new ErrorStructure<String>();
        error.setErorCode(HttpStatus.FOUND.value());
        error.setErrorMessage(ex.getMessage());
        error.setError(" User already exist");

        return new ResponseEntity<ErrorStructure<String>>(error,HttpStatus.FOUND);
=======
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handlerUserNotFound(UserNotFoundException ex){

        ErrorStructure<String> error = new ErrorStructure<String>();
        error.setErorCode(HttpStatus.NOT_FOUND.value());
        error.setErrorMessage(ex.getMessage());
        error.setError(" User does't exist");

        return new ResponseEntity<ErrorStructure<String>>(error,HttpStatus.NOT_FOUND);
>>>>>>> master
    }
}

package com.example.mtb.responsebuilder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseBuilder {

    public <T>ResponseEntity<ResponseStructure<T>> success(HttpStatus status,String message,T data){
        ResponseStructure<T> structure = ResponseStructure.<T> builder()
                .statusCode(status.value())
                .message(message)
                .data(data)
                .build();;

        return  new ResponseEntity<>(structure,status);
    }
}

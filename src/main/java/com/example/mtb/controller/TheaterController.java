package com.example.mtb.controller;


import com.example.mtb.dto.TheaterRegistrationRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.responsebuilder.ResponseBuilder;
import com.example.mtb.responsebuilder.ResponseStructure;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TheaterController {

    private final TheaterService theaterService;

    @Autowired
    private ResponseBuilder responseBuilder;


    @PostMapping("/theater")
    public ResponseEntity<ResponseStructure<TheaterResponse>> registration(@RequestParam String email, @RequestBody TheaterRegistrationRequest request){
        TheaterResponse theater = theaterService.registration(email,request);

        return responseBuilder.success(HttpStatus.CREATED,"theater registrated succcessfully ",theater);
    }
}

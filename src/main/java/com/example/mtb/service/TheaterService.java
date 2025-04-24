package com.example.mtb.service;

import com.example.mtb.dto.TheaterRegistrationRequest;
import com.example.mtb.dto.TheaterResponse;

public interface TheaterService {
    TheaterResponse registration(String email,TheaterRegistrationRequest request);
}

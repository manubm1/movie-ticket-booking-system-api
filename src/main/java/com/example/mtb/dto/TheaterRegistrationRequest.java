package com.example.mtb.dto;

public record TheaterRegistrationRequest (String name,
                                          String address,
                                          String city,
                                          String landmark,
                                          Long createAt,
                                          Long updatedAt,
                                          Long createdBy) {
}

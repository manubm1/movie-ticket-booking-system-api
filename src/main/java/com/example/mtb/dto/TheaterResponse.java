package com.example.mtb.dto;

public record TheaterResponse(String name,
                              String address,
                              String city,
                              String landmark,
                              Long createAt,
                              Long updatedAt,
                              String createdBy)
{

}

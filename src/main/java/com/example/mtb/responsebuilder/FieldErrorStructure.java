package com.example.mtb.responsebuilder;

import lombok.Builder;

@Builder
public class FieldErrorStructure<T> {

    int statusCode;
    String message;
    T error;
}

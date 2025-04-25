package com.example.mtb.responsebuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FieldErrorStructure<T> {

    int statusCode;
    String message;
    T error;
}

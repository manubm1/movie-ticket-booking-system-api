package com.example.mtb.utility;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorStructure<T> {

    private int erorCode;
    private String errorMessage;
    private  T error;
}

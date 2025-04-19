package com.example.mtb.responsebuilder;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Builder
public class ResponseStructure<T> {

    private int statusCode;
    private String message;
    private T data;
}

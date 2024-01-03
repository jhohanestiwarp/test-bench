package com.lilab.inventory.models;

import lombok.Getter;
import lombok.Setter;

public class OperationResponse {

    @Getter
    @Setter
    private double result;

    @Getter
    @Setter
    private int errorCode;

    @Getter
    @Setter
    private String errorMessage;

}

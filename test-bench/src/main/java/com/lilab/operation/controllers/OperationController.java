package com.lilab.operation.controllers;

import com.lilab.operation.models.OperationRequest;
import com.lilab.operation.models.OperationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @PostMapping("/performOperation")
    public OperationResponse performOperation(@RequestBody OperationRequest request) {
        OperationResponse response = new OperationResponse();

        try {
            double result = performMathOperation(request.getValueA(), request.getValueB());
            BigDecimal formattedResult = BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP);
            response.setResult(formattedResult.doubleValue());
            response.setErrorCode(1);
        } catch (Exception e) {
            response.setErrorCode(2);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }

    private double performMathOperation(int valueA, int valueB) {
        if (valueA == 0) {
            throw new IllegalArgumentException("El valor de 'valueA' no puede ser cero.");
        }

        return (double) valueB / valueA;
    }
}

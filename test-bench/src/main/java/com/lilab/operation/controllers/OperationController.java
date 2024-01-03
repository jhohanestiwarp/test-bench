package com.lilab.operation.controllers;


import com.lilab.operation.models.OperationRequest;
import com.lilab.operation.models.OperationResponse;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;


@RestController
@RequestMapping("/operation")
class OperationController {

    @PostMapping("/performOperation")
    public OperationResponse performOperation(@RequestBody OperationRequest request) {
        OperationResponse response = new OperationResponse();

        try {
            double result = performMathOperation(request.getValueA(), request.getValueB());
            DecimalFormat formato = new DecimalFormat("#.##");
            String numeroFormateado = formato.format(result);
            result = Double.parseDouble(numeroFormateado);
            response.setResult(result);
            response.setErrorCode(1);
        } catch (Exception e) {
            response.setErrorCode(2);
            response.setErrorMessage(e.getMessage());
        }

        return response;
    }

    private double performMathOperation(int valueA, int valueB) {
        return valueB / valueA;
    }
}



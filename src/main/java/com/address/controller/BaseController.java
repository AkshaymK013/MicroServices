package com.address.controller;

import com.address.core.AddressResponse;
import org.springframework.http.ResponseEntity;

public class BaseController {
    protected ResponseEntity<?> buildResponse(AddressResponse addressResponse) {
        return ResponseEntity.status(addressResponse.getStatus()).body(addressResponse);
    }

}

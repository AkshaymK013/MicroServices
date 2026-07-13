package com.address.controller;

import com.address.core.AddressResponse;
import com.address.dto.AddressResponseDto;
import com.address.dto.CreateAddressRequestDto;
import com.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/address")
public class AddressController  extends BaseController{

    @Autowired
    AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@Validated  @RequestBody CreateAddressRequestDto
                                                       createAddressRequestDto) {
        return buildResponse(addressService.createAddress(createAddressRequestDto));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable BigInteger id) {
        return buildResponse(addressService.getById(id));
    }

}

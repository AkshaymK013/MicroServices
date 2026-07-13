package com.address.service;

import com.address.core.AddressResponse;
import com.address.core.Status;
import com.address.dto.AddressResponseDto;
import com.address.dto.CreateAddressRequestDto;
import com.address.entity.Address;
import com.address.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@Slf4j
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequestDto createAddressRequestDto){
        return buildaddressResponse(createAddressRequestDto);
    }

    public AddressResponse getById(BigInteger id) {

        log.info("id is invoking.......");
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        log.info("Id {} :" + id);

        AddressResponseDto dto = new AddressResponseDto(address);
        System.out.println("dto:" + dto);

        return AddressResponse.builder()
                .status(HttpStatus.OK)
                .responseStatus(Status.success)
                .responseBody(dto)
                .build();
    }

    private AddressResponse buildaddressResponse(CreateAddressRequestDto createAddressRequestDto) {
        Address address = new Address();
        address.setStreet(createAddressRequestDto.getStreet());
        address.setCity(createAddressRequestDto.getCity());
          address = addressRepository.save(address);
        AddressResponseDto addressResponseDto = new AddressResponseDto(address);
        return  AddressResponse.builder()
                .status(HttpStatus.OK)
                .responseStatus(Status.success)
                .responseBody(addressResponseDto)
                .build();
    }


}

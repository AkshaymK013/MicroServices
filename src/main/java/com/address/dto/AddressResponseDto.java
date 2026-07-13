package com.address.dto;

import com.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddressResponseDto {

    private BigInteger addressId;
    private String street;
    private String city;

    public AddressResponseDto(Address address) {
        this.addressId = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }

}

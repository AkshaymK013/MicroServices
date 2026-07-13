package com.address.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class AddressResponse {

    @JsonIgnore
    private HttpStatus status;
    private Status responseStatus;
    private Object responseBody;

}

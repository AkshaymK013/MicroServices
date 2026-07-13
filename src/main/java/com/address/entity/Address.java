package com.address.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Table(name = "Address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private BigInteger id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private  String city;
}

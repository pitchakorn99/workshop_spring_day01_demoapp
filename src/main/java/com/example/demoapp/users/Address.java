package com.example.demoapp.users;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: pitchakorn.jo
 * Created by: ModelGenerator on 9/7/2021
 */
@Getter
@Setter
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
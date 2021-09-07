package com.example.demoapp.users;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: pitchakorn.jo
 * Created by: ModelGenerator on 9/7/2021
 */
@Getter
@Setter
public class Users {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
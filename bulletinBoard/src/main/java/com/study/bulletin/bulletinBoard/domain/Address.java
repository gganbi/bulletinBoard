package com.study.bulletin.bulletinBoard.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/**
 * Created by holyeye on 2014. 3. 11..
 */
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}

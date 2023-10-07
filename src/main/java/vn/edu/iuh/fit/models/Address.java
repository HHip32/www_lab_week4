package vn.edu.iuh.fit.models;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data

public class Address {
    private String id;
    private String street;
    private String city;
    private int country;
    private String number;
    private String zipCode;


}

package vn.edu.iuh.fit.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Address {
    private UUID id;
    private String city;
    private Short country;
    private String number;
    private String zipCode;

}

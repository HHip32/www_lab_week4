package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    private long id;
    private String about;
    private String email;
    private String companyName;
    private String phone;
    private String webUrl;
    private Address address;
}

package vn.edu.iuh.fit.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Company {
    private UUID id;
    private String about;
    private String email;
    private String companyName;
    private String phone;
    private String webUrl;
    private Address address;
}

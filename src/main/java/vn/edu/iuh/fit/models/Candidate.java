package vn.edu.iuh.fit.models;

import lombok.Data;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class Candidate {
    private UUID id;

    private LocalTime dob;
    private String email;
    private String fullName;
    private String phone;
    private Address address;

}

package vn.edu.iuh.fit.models;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Candidate {
    private long id;
    private LocalDateTime dob;
    private String email;
    private String fullName;
    private String phone;
    private Address address;

}

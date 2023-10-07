package vn.edu.iuh.fit.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Job {
    private long id;
    private String jobDescription;
    private String jobName;
    private Company company;
}

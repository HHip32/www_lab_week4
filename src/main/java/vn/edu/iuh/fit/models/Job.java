package vn.edu.iuh.fit.models;


import lombok.Data;
import java.util.UUID;

@Data
public class Job {
    private UUID id;
    private String jobDescription;
    private String jobName;
    private Company company;
}

package vn.edu.iuh.fit.models;

import lombok.Data;
import java.util.UUID;

@Data
public class Skill {
    private UUID id;
    private String skillName;
    private String skillDescription;
    private Short type;
}

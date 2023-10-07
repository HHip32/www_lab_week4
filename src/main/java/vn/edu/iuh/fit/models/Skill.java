package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Skill {
    private long id;
    private String skillName;
    private String skillDescription;
    private Short type;
}

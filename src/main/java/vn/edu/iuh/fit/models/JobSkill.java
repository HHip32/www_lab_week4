package vn.edu.iuh.fit.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobSkill {
    private String moreInformation;
    private Short skillLevel;
    private Job job;
    private Skill skill;
}

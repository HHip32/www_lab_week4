package vn.edu.iuh.fit.models;

import lombok.Data;

@Data
public class JobSkill {
    private String moreInformation;
    private Short skillLevel;
    private Job job;
    private Skill skill;
}

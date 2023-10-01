package vn.edu.iuh.fit.models;


import lombok.Data;
import java.util.UUID;

@Data
public class CandidateSkill {
    private UUID id;
    private Short skillLevel;
    private String moreInfomation;
    private Candidate candidate;
    private Skill skill;
}

package vn.edu.iuh.fit.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateSkill {
    private Short skillLevel;
    private String moreInfomation;
    private Candidate candidate;
    private Skill skill;
}

package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.CandidateSkill;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CandidateSkill_DAO extends Abstract_DAO<CandidateSkill, Long> {
    public CandidateSkill_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(CandidateSkill candidateSkill) {
        jdbcTemplate.update("insert into candidate_skill values (?,?,?,?);"
                , candidateSkill.getMoreInfomation()
                , candidateSkill.getSkillLevel()
                , candidateSkill.getSkill().getId()
                , candidateSkill.getCandidate().getId()
        );
    }

    @Override
    public void update(CandidateSkill candidateSkill) {
        String sql = "update candidate_skill set more_infos = ?, skill_level = ?"
                + " where skill_id = ? and can_id = ?;";
        jdbcTemplate.update(sql
                , candidateSkill.getMoreInfomation()
                , candidateSkill.getSkillLevel()
                , candidateSkill.getSkill().getId()
                , candidateSkill.getCandidate().getId()
        );
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public CandidateSkill getById(Long aLong) {
       return null;
    }

    @Override
    public List<CandidateSkill> getALL() {
        String sql = "select * from candidate_skill";
        return jdbcTemplate.query(
                sql
                , new BeanPropertyRowMapper<>(CandidateSkill.class)
        );
    }
}

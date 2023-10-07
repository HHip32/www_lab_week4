package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import vn.edu.iuh.fit.models.JobSkill;

import javax.sql.DataSource;
import java.util.List;

public class JobSkill_DAO extends Abstract_DAO<JobSkill, Long> {
    public JobSkill_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(JobSkill jobSkill) {
        jdbcTemplate.update("insert into job_skill values (?,?,?,?);"
                , jobSkill.getMoreInformation()
                , jobSkill.getSkillLevel()
                , jobSkill.getJob().getId()
                , jobSkill.getSkill().getId()
        );
    }

    @Override
    public void update(JobSkill jobSkill) {
        String sql = "update job_skill set more_infos = ?, skill_level = ?"
                + " where skill_id = ? and job_id = ?;";
        jdbcTemplate.update(sql
                , jobSkill.getMoreInformation()
                , jobSkill.getSkillLevel()
                , jobSkill.getSkill().getId()
                , jobSkill.getJob().getId()
        );
    }

    @Override
    public boolean delete(Long aLong) {
        return false;
    }

    @Override
    public JobSkill getById(Long aLong) {
        return null;
    }

    @Override
    public List<JobSkill> getALL() {
        String sql = "select * from job_skill";
        return jdbcTemplate.query(
                sql
                , new BeanPropertyRowMapper<>(JobSkill.class)
        );
    }
}

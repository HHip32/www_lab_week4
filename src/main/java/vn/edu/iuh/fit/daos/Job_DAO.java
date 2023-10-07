package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Job;

import javax.sql.DataSource;
import java.util.List;
@Component
public class Job_DAO extends Abstract_DAO<Job, Long> {
    public Job_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Job job) {
        jdbcTemplate.update("insert into job values (?,?,?,?,?,?);"
                , job.getId()
                , job.getJobDescription()
                , job.getJobName()
                , job.getCompany().getId()
        );
    }

    @Override
    public void update(Job job) {
        String sql = "update job set job_desc = ?, job_name = ?, company = ?"
                + " where job_id = ?;";
        jdbcTemplate.update(sql
                , job.getJobDescription()
                , job.getJobName()
                , job.getCompany().getId()
                , job.getId()
        );
    }

    @Override
    public boolean delete(Long aLong) {
        String sql = "delete from job"
                + " where job_id = ?";

        return jdbcTemplate.update(sql, aLong) > 0;
    }

    @Override
    public Job getById(Long aLong) {
        String sql = "select * from job"
                + " where job_id = ?";
        return jdbcTemplate.queryForObject(
                sql
                , new BeanPropertyRowMapper<>(Job.class)
                , aLong
        );
    }

    @Override
    public List<Job> getALL() {
        return jdbcTemplate.query(
                "select * from job"
                , new BeanPropertyRowMapper<>(Job.class)
        );
    }
}

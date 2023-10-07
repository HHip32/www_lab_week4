package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Candidate;

import javax.sql.DataSource;
import java.util.List;

@Component
public class Candidate_DAO extends Abstract_DAO<Candidate, Long> {
    public Candidate_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Candidate candidate) {
        jdbcTemplate.update("insert into candidate values (?,?,?,?,?,?);"
                , candidate.getId()
                , candidate.getDob()
                , candidate.getEmail()
                , candidate.getFullName()
                , candidate.getPhone()
                , candidate.getAddress().getId()
        );
    }

    @Override
    public void update(Candidate candidate) {
        String sql = "update candidate set dob = ?, email = ?, full_name = ?, phone = ?, address = ?"
                + " where id = ?;";
        jdbcTemplate.update(sql
                , candidate.getDob()
                , candidate.getEmail()
                , candidate.getFullName()
                , candidate.getPhone()
                , candidate.getAddress().getId()
                , candidate.getId());
    }

    @Override
    public boolean delete(Long aLong) {
        String sql = "delete from candidate"
                + " where id = ?";

        return jdbcTemplate.update(sql, aLong) > 0;
    }

    @Override
    public Candidate getById(Long aLong) {
        String sql = "select * from candidate"
                + " where id = ?";
        return jdbcTemplate.queryForObject(
                sql
                , new BeanPropertyRowMapper<>(Candidate.class)
                , aLong
        );
    }

    @Override
    public List<Candidate> getALL() {
        return jdbcTemplate.query(
                "select * from candidate"
                , new BeanPropertyRowMapper<>(Candidate.class)
        );
    }
}

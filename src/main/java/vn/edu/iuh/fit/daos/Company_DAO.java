package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Company;

import javax.sql.DataSource;
import java.util.List;

@Component
public class Company_DAO extends Abstract_DAO<Company, Long> {
    public Company_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Company company) {
        String sql = "insert into company values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql
                , company.getId()
                , company.getAbout()
                , company.getEmail()
                , company.getCompanyName()
                , company.getPhone()
                , company.getWebUrl()
                , company.getAddress().getId()
        );
    }

    @Override
    public void update(Company company) {
        String sql = "update company set about = ?, email = ?, comp_name = ?, phone = ?, web_url = ?, address = ?"
                + " where comp_id = ?";
        jdbcTemplate.update(sql
                , company.getAbout()
                , company.getEmail()
                , company.getCompanyName()
                , company.getPhone()
                , company.getWebUrl()
                , company.getAddress().getId()
                , company.getId()
        );
    }

    @Override
    public boolean delete(Long aLong) {
        String sql = "delete from company"
                + " where comp_id = ?";
        return jdbcTemplate.update(sql, aLong) > 0;
    }

    @Override
    public Company getById(Long aLong) {
        String sql = "select * from company"
                + " where comp_id = ?";
        return jdbcTemplate.queryForObject(
                sql
                , new BeanPropertyRowMapper<>(Company.class)
                , aLong
        );
    }

    @Override
    public List<Company> getALL() {
        return jdbcTemplate.query(
                "select * from company"
                , new BeanPropertyRowMapper<>(Company.class)
        );
    }
}

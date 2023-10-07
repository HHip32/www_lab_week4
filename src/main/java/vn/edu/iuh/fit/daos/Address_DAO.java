package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Address;

import javax.sql.DataSource;
import java.util.List;

@Component
public class Address_DAO extends Abstract_DAO<Address, String> {
    public Address_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Address address) {
        String sql = "insert into address values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql
                , address.getId()
                , address.getStreet()
                , address.getCity()
                , address.getCountry()
                , address.getNumber()
                , address.getZipCode());
    }

    @Override
    public void update(Address address) {
        String sql = "update address set street = ?, city = ?, country = ?, number = ?, zipcode = ?"
                + " where id = ?";
        jdbcTemplate.update(
                sql
                , address.getStreet()
                , address.getCity()
                , address.getCountry()
                , address.getNumber()
                , address.getZipCode()
                , address.getId());

    }

    @Override
    public boolean delete(String s) {
        String sql = "delete from address"
                + " where id = ?";

        return jdbcTemplate.update(sql, s) > 0;
    }

    @Override
    public Address getById(String s) {
        String sql = "select * from address"
                + " where id = ?";
        return jdbcTemplate.queryForObject(
                sql
                , new BeanPropertyRowMapper<>(Address.class)
                , s
        );
    }

    @Override
    public List<Address> getALL() {
        String sql = "select * from address";
        return jdbcTemplate.query(
                sql
                , new BeanPropertyRowMapper<>(Address.class)
        );
    }
}

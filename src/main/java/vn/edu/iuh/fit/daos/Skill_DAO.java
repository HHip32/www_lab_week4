package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import vn.edu.iuh.fit.models.Skill;

import javax.sql.DataSource;
import java.util.List;
@Component
public class Skill_DAO extends Abstract_DAO<Skill, Long> {
    public Skill_DAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Skill skill) {
        jdbcTemplate.update("insert into skill values (?,?,?,?);"
                , skill.getId()
                , skill.getSkillDescription()
                , skill.getSkillName()
                , skill.getType()
        );
    }

    @Override
    public void update(Skill skill) {
        String sql = "update skill set skill_description = ?, skill_name = ?, type = ?"
                + " where skill_id = ?;";
        jdbcTemplate.update("insert into skill values (?,?,?,?);"
                , skill.getSkillDescription()
                , skill.getSkillName()
                , skill.getType()
                , skill.getId()
        );
    }

    @Override
    public boolean delete(Long aLong) {
        String sql = "delete from skill"
                + " where skill_id = ?";

        return jdbcTemplate.update(sql, aLong) > 0;
    }

    @Override
    public Skill getById(Long aLong) {
        String sql = "select * from skill"
                + " where skill_id = ?";
        return jdbcTemplate.queryForObject(
                sql
                , new BeanPropertyRowMapper<>(Skill.class)
                , aLong
        );
    }

    @Override
    public List<Skill> getALL() {
        String sql = "select * from skill";
        return jdbcTemplate.query(
                sql
                , new BeanPropertyRowMapper<>(Skill.class)
        );
    }
}

package vn.edu.iuh.fit.daos;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public abstract class Abstract_DAO<T, ID> {
    protected final DataSource dataSource;
    protected final JdbcTemplate jdbcTemplate;

    public Abstract_DAO(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public abstract void insert(T t);
    public abstract void update(T t);
    public abstract boolean delete(ID id);
    public abstract T getById(ID id);
    public abstract List<T> getALL();

}

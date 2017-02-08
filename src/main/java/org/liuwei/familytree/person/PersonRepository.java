package org.liuwei.familytree.person;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by apple on 2017/2/3.
 */
@Component
public class PersonRepository {
    private static final String SQL_BY_ID = "select * from person where id=?";
    private static DataSource initDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/family-tree?characterEncoding=utf8&useSSL=true",
                "root", "123abc-");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    private static final JdbcTemplate jdbcTemplate = new JdbcTemplate(initDataSource());


    public static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person.Builder(rs.getString("id"))
                    .name(rs.getString("name"))
                    .introduce(rs.getString("introduce"))
                    .six(Enum.valueOf(Person.Six.class, rs.getString("six"))).build();
            return person;
        }

    }

    public Person byId(String id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, new Object[]{id}, new PersonRowMapper());
    }
}

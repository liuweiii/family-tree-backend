package org.liuwei.familytree.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by apple on 2017/2/3.
 */
@Repository
public class PersonRepository {
    private static final String SQL_BY_ID = "select * from person where id=?";
    private static final String SQL_LIST = "select * from person";

    @Autowired
    JdbcTemplate jdbcTemplate;

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

    public List<Person> list() {
        return jdbcTemplate.query(SQL_LIST, new PersonRowMapper());
    }

    public Person byId(String id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, new Object[]{id}, new PersonRowMapper());
    }
}

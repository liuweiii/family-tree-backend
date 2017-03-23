package org.liuwei.familytree.person;

import org.liuwei.familytree.utils.Paginate;
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
    private static final String SQL_SEARCH_BY_NAME = "select * from person where name" +
            " like '%%%s%%' limit %s,%s";
    private static final String SQL_SEARCH_BY_NAME_COUNT = "select count(*) from person where name"+
            " like '%%%s%%'";
    private static final String SQL_GET_CHILDREN = "select child.* from person as me join person as child " +
            "on me.id = child.%s where me.id=?";
    private static final String SQL_LIST = "select * from person";
    private static final String SQL_BY_CHILD_ID = "select myFamily.* from person as me join person as myFamily " +
            "on me.%s = myFamily.id where me.id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static class PersonRowMapper implements RowMapper<Person> {

        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person.Builder(rs.getString("id"))
                    .name(rs.getString("name"))
                    .introduce(rs.getString("introduce"))
                    .six(Enum.valueOf(Person.Six.class, rs.getString("six")))
                    .fatherId(rs.getString("fatherId"))
                    .motherId(rs.getString("motherId"))
                    .spouseId(rs.getString("spouseId"))
                    .birthday(rs.getDate("birthday"))
                    .dieday(rs.getDate("dieday"))
                    .build();
            return person;
        }

    }

    public List<Person> all() {
        return jdbcTemplate.query(SQL_LIST, new PersonRowMapper());
    }

    public Person byId(String id) {
        return jdbcTemplate.queryForObject(SQL_BY_ID, new Object[]{id}, new PersonRowMapper());
    }

    public Person getByMyId(String field, String myId) {
        try {
            return jdbcTemplate.queryForObject(String.format(SQL_BY_CHILD_ID, field),
                    new Object[]{myId}, new PersonRowMapper());
        } catch (Exception e) {
            return null;
        }
    }

    public Paginate<Person> searchByName(String name, int pageSize, int pageIndex) {
        try {
            int from = (pageIndex-1)*pageSize;
            List<Person> persons = jdbcTemplate.query(String.format(SQL_SEARCH_BY_NAME, name, from,pageSize),
                    new PersonRowMapper());
            int total = jdbcTemplate.queryForObject(String.format(SQL_SEARCH_BY_NAME_COUNT, name), Integer.class);
            return new Paginate<>(total, persons);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Person> getChildren(String myId, Person.Six mySix) {
        try {
            String field;
            switch (mySix) {
                case female: {
                    field = "motherId";
                    break;
                }
                case male: {
                    field = "fatherId";
                    break;
                }
                default: {
                    throw new IllegalArgumentException(" unknown six, can't get children.");
                }
            }
            if (mySix == Person.Six.female) {

            }
            return jdbcTemplate.query(String.format(SQL_GET_CHILDREN, field),
                    new Object[]{myId}, new PersonRowMapper());
        } catch (Exception e) {
            return null;
        }
    }
}

package org.liuwei.familytree.person;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by apple on 2017/2/11.
 */
public class PersonRepositoryTest {

    private PersonRepository personRepository;

    @Before
    public void setUp() {
        personRepository = new PersonRepository();
        personRepository.jdbcTemplate = mock(JdbcTemplate.class);
    }

    @Test
    public void shouldGetAllPersonsSucceed() {
        when(personRepository.jdbcTemplate.query(any(String.class), any(RowMapper.class))).thenReturn(null);
        personRepository.all();
        verify(personRepository.jdbcTemplate).query(eq("select * from person"), any(RowMapper.class));
    }

    @Test
    public void shouldGetByIdSucceed() {
        when(personRepository.jdbcTemplate.queryForObject(any(String.class), any(Object[].class), any(RowMapper.class)))
                .thenReturn(null);
        personRepository.byId("123");
        verify(personRepository.jdbcTemplate).queryForObject(eq("select * from person where id=?")
                ,any(Object[].class), any(RowMapper.class));
    }

    @Test
    public void shouldGetFatherSucceed(){
        when(personRepository.jdbcTemplate.queryForObject(any(String.class), any(Object[].class), any(RowMapper.class)))
                .thenReturn(null);
        personRepository.getByMyId("fatherId", "123");
        verify(personRepository.jdbcTemplate).queryForObject(
                eq("select myFamily.* from person as me join person as myFamily " +
                        "on me.fatherId = myFamily.id where me.id = ?"),
                any(Object[].class), any(RowMapper.class));
    }
}

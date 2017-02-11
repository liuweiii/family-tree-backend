package org.liuwei.familytree.person;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void setUp(){
        personRepository = new PersonRepository();
        personRepository.jdbcTemplate = mock(JdbcTemplate.class);
    }

    @Test
    public void shouldGetAllPersons(){
        when(personRepository.jdbcTemplate.query(any(String.class), any(RowMapper.class))).thenReturn(null);
        personRepository.all();
        verify(personRepository.jdbcTemplate).query(eq("select * from person"),any(RowMapper.class));
    }
}

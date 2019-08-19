package com.app.rc.getting_started_with_jpa_relationships.data.dao;

import com.app.rc.getting_started_with_jpa_relationships.data.entity.BooksEntity;
import com.app.rc.getting_started_with_jpa_relationships.shared.dto.BooksDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class BooksDAOImplTest {

    @InjectMocks
    BooksDAOImpl testObj;

    @Mock
    JdbcTemplate jdbcTemplate;


    List<BooksDTO> list = new ArrayList<>();

    @BeforeEach
    void setup(){
        list.add(new BooksDTO());
        when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(BeanPropertyRowMapper.class))).thenReturn(list);
    }

    @Test
    void getAllBooksData() {
        final List<BooksDTO> result = testObj.getAllBooksData();
        assertNotNull(result);
    }
}
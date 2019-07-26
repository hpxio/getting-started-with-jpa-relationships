package com.app.rc.getting_started_with_jpa_relationships.data.dao;

import com.app.rc.getting_started_with_jpa_relationships.data.entity.BooksEntity;
import com.app.rc.getting_started_with_jpa_relationships.exceptionHandler.GenericExceptionDataNotFound;
import com.app.rc.getting_started_with_jpa_relationships.shared.dto.BooksDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BooksDAO {

    private static final String FIND_BOOK_BY_ID = "SELECT * FROM BOOKS WHERE ID=?";
    private static final String FIND_BOOK_ALL = "SELECT * FROM BOOKS";

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Get all the Books records from the Books Table
     *
     * @return Books data list
     */
    public List<BooksDTO> getAllBooksData() {

        /* Request/Response placeholders */
        List<BooksEntity> result;
        List<BooksDTO> listDestination = new ArrayList<>();

        /* Get response from DB */
        result = jdbcTemplate.query(FIND_BOOK_ALL, new BeanPropertyRowMapper<>(BooksEntity.class));

        /* Prepare response for UI */
        for (Object source : result) {
            BooksDTO target = new BooksDTO();
            BeanUtils.copyProperties(source, target);
            listDestination.add(target);
        }
        return listDestination;
    }

    /**
     * Get Book record from ID
     *
     * @return Book Object found by given ID
     */
    public BooksDTO findBookById(int id) {
        final BooksDTO response = new BooksDTO();
        final BooksEntity result;

        try {
            result = jdbcTemplate.queryForObject(FIND_BOOK_BY_ID,
                    new Object[]{id}, new BeanPropertyRowMapper<>(BooksEntity.class));
        } catch (InvalidResultSetAccessException e) {
            throw new GenericExceptionDataNotFound(e.getMessage());
        } catch (DataAccessException e) {
            throw new GenericExceptionDataNotFound(e.getMessage());
        }

        BeanUtils.copyProperties(result, response);
        return response;
    }
}
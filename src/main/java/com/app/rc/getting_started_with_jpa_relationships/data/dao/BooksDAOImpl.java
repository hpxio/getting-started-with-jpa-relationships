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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BooksDAOImpl implements BooksDAO {

    private static final String FIND_BOOK_BY_ID = "SELECT * FROM BOOKS WHERE ID=?";
    private static final String FIND_BOOK_ALL = "SELECT * FROM BOOKS";
    private static final String FIND_LAST_ID = "SELECT MAX(ID) FROM BOOKS";
    private static final String DELETE_BOOK_BY_ID = "DELETE FROM BOOKS WHERE ID=?";
    private static final String CREATE_BOOK_DATA = "INSERT INTO BOOKS(ID, CATEGORY, CREATED_AT, NAME, SHELF, STATUS, " +
            "UPDATED_AT) VALUES(?,?,?,?,?,?,?)";

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

    /**
     * Get the last highest ID stored in the table
     * @return Greatest stored ID in the Books table
     */
    public int findLastId(){
        return jdbcTemplate.queryForObject(FIND_LAST_ID, Integer.class);
    }

    /**
     * Delete book record
     *
     * @param id UUID of the Book record
     * @return Number of rows affected after delete operation
     */
    public int deleteBook(int id) {
        return jdbcTemplate.update(DELETE_BOOK_BY_ID, id);
    }

    /**
     * FIXME: AUTO_INCREMENT not working
     * Create book record
     *
     * @param entity Book data to be stored
     * @return Number of rows created
     */
    public int createBookData(BooksEntity entity) {
        return jdbcTemplate.update(CREATE_BOOK_DATA, entity.getId(), entity.getCategory(), entity.getCreatedAt(),
                entity.getName(), entity.getShelf(), entity.isStatus(), entity.getUpdatedAt());
    }
}
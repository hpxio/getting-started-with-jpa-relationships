package com.app.rc.getting_started_with_jpa_relationships.data.dao;

import com.app.rc.getting_started_with_jpa_relationships.data.entity.BooksEntity;
import com.app.rc.getting_started_with_jpa_relationships.shared.dto.BooksDTO;

import java.util.List;

public interface BooksDAO {
    List<BooksDTO> getAllBooksData();

    BooksDTO findBookById(int id);

    int deleteBook(int id);

    int createBookData(BooksEntity entity);
}

package com.app.rc.getting_started_with_jpa_relationships.data.repository;

import com.app.rc.getting_started_with_jpa_relationships.data.entity.BooksEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends CrudRepository<BooksEntity, Integer> {
}

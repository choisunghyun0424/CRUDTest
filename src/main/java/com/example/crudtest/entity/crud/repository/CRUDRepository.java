package com.example.crudtest.entity.crud.repository;

import com.example.crudtest.entity.crud.CRUD;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CRUDRepository extends CrudRepository<CRUD, Long> {
    Page<CRUD> findAll(Pageable pageable);
    Optional<CRUD> findByListId(Long listId);
    void deleteByListId(Long listId);
}

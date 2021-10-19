package com.example.crudtest.service;

import com.example.crudtest.payload.request.CreateCRUDRequest;
import com.example.crudtest.payload.request.UpdateCRUDRequest;
import com.example.crudtest.payload.response.CRUDResponse;

import java.util.List;

public interface CRUDService {
    void createCRUD(CreateCRUDRequest createCRUDRequest);
    void updateCRUD(Long listId, UpdateCRUDRequest updateCRUDRequest);
    void deleteCRUD(Long listId);
    List<CRUDResponse> readCRUD(int pageNum);
}

package com.example.crudtest.controller;

import com.example.crudtest.payload.request.CreateCRUDRequest;
import com.example.crudtest.payload.request.UpdateCRUDRequest;
import com.example.crudtest.payload.response.CRUDResponse;
import com.example.crudtest.service.CRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class CRUDController {

    private final CRUDService crudService;

    @GetMapping("/{pageNum}")
    public List<CRUDResponse> readCRUD(@PathVariable int pageNum) {
        return crudService.readCRUD(pageNum);
    }

    @PostMapping
    public void createCRUD(@RequestBody CreateCRUDRequest createCRUDRequest) {
        crudService.createCRUD(createCRUDRequest);
    }

    @PutMapping("/{listId}")
    public void updateCRUD(@PathVariable Long listId,
                           @RequestBody UpdateCRUDRequest updateCRUDRequest) {
        crudService.updateCRUD(listId, updateCRUDRequest);
    }

    @DeleteMapping("/{listId}")
    public void deleteCRUD(@PathVariable Long listId) {
        crudService.deleteCRUD(listId);
    }
}

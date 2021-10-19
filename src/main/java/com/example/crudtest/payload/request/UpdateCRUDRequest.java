package com.example.crudtest.payload.request;

import lombok.Getter;

@Getter
public class UpdateCRUDRequest {
    private String title;
    private String content;
}

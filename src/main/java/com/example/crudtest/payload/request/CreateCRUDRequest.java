package com.example.crudtest.payload.request;

import lombok.Getter;

@Getter
public class CreateCRUDRequest {
    private String title;
    private String content;
}

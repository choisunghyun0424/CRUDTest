package com.example.crudtest.service;

import com.example.crudtest.entity.crud.CRUD;
import com.example.crudtest.entity.crud.repository.CRUDRepository;
import com.example.crudtest.payload.request.CreateCRUDRequest;
import com.example.crudtest.payload.request.UpdateCRUDRequest;
import com.example.crudtest.payload.response.CRUDResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CRUDServiceImpl implements CRUDService{

    private final CRUDRepository crudRepository;

    @Override
    public void createCRUD(CreateCRUDRequest createCRUDRequest) {               //클라에게 title, content값을 받아오는 함수
        crudRepository.save(                                                    //Crud 테이블에 저장하는 기능을하는 CrudRepository의 함수
                CRUD.builder()                                                  //@Builder어노테이션을 이용한 새로운 CRUD를 생성해주는 코드
                        .title(createCRUDRequest.getTitle())
                        .content(createCRUDRequest.getContent())
                        .build()
        );
    }

    @Override
    public void updateCRUD(Long listId, UpdateCRUDRequest updateCRUDRequest) {
        CRUD crud = crudRepository.findById(listId)
                        .orElseThrow(RuntimeException::new);

        crud.update(updateCRUDRequest.getTitle(), updateCRUDRequest.getContent());

        crudRepository.save(crud);
    }

    @Override
    @Transactional
    public void deleteCRUD(Long listId) {
        crudRepository.deleteByListId(listId);
    }

    //내일까지 알아오기(2021.10.15) : Builder 패턴, 페이징 처리, for each문(자바 기본문법), List(내부 메서드들)와 제네릭 사용법

    @Override
    public List<CRUDResponse> readCRUD(int pageNum) {                          //list형식으로 listId, title, content 받아오는 함수
        Page<CRUD> crudList = crudRepository.findAll(PageRequest.of(pageNum, 10));             //DB에 CRUD테이블의 모든 값 가져오기

        List<CRUDResponse> responses = new ArrayList<>();           // responses 리스트 생성
        for(CRUD crud : crudList) {                                 // crudList 첫 번째 인덱스부터 하나씩 CRUD변수에 넣어준다.
            responses.add(                                          // CRUDResponses List에 요소 추가
                    CRUDResponse.builder()                          // 요소를 생성
                            .listId(crud.getListId())
                            .title(crud.getTitle())
                            .content(crud.getContent())
                            .build()
            );
        }

        return responses;                                           // responses list를 반환
    }
}

package com.crud.library.controllers;

import com.crud.library.domain.Borrow;
import com.crud.library.dto.BorrowDto;
import com.crud.library.mappers.BorrowMapper;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("v1/library/borrows")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowMapper borrowMapper;
    private final DbService dbService;

    @GetMapping
    public List<BorrowDto> getBorrows() {
        List<Borrow> borrowList = dbService.getAllBorrows();
        return borrowMapper.mapToBorrowDtoList(borrowList);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BorrowDto> createBorrow(@RequestBody BorrowDto borrowDto) {

        Borrow borrow = borrowMapper.mapToCreateBorrow(borrowDto);
        Borrow savedBorrow = dbService.saveBorrow(borrow);
        return ResponseEntity.ok(borrowMapper.mapToBorrowDto(savedBorrow));
    }

}

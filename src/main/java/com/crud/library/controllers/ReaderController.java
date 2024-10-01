package com.crud.library.controllers;

import com.crud.library.domain.Reader;
import com.crud.library.dto.ReaderDto;
import com.crud.library.errors.ReaderNotFoundException;
import com.crud.library.mappers.ReaderMapper;
import com.crud.library.repository.ReaderDao;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library/readers")
public class ReaderController {

     private final ReaderMapper readerMapper;
     private final DbService dbService;


    @Autowired
    public ReaderController(ReaderMapper readerMapper, DbService dbService) {
        this.readerMapper = readerMapper;
        this.dbService = dbService;
    }

    @GetMapping
    public List<ReaderDto> getReaders() {
        List<Reader> readers = dbService.getAllReaders();
        return readerMapper.mapToReaderDtoList(readers);
    }

    @GetMapping(value="{readerId}")
    public ResponseEntity<ReaderDto> getReader(@PathVariable Long readerId) throws ReaderNotFoundException {
        return ResponseEntity.ok(readerMapper.mapToReaderDto(dbService.getReader(readerId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        dbService.saveReader(reader);
    }

    @PutMapping
    public ResponseEntity<ReaderDto> updateReader(@RequestBody ReaderDto readerDto) {
        Reader reader = readerMapper.mapToReader(readerDto);
        Reader savedReader = dbService.saveReader(reader);
        return ResponseEntity.ok(readerMapper.mapToReaderDto(savedReader));
    }

    @DeleteMapping(value = "{readerId}")
    public ResponseEntity<Void> deleteReader(@PathVariable Long readerId) {
        dbService.deleteReaderById(readerId);
        return ResponseEntity.ok().build();
    }

}

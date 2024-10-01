package com.crud.library.controllers;

import com.crud.library.domain.Title;
import com.crud.library.dto.TitleDto;
import com.crud.library.errors.TitleNotFoundException;
import com.crud.library.mappers.ReaderMapper;
import com.crud.library.mappers.TitleMapper;
import com.crud.library.repository.TitleDao;
import com.crud.library.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library/titles")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TitleController {
    private final TitleMapper titleMapper;
    private final DbService dbService;


    @GetMapping
    public List<TitleDto> getTitles() {
        List<Title> titles = dbService.getAllTitles();
        return titleMapper.mapToTitleDtoList(titles);
    }
    @GetMapping(value="{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable Long titleId) throws TitleNotFoundException {
        return ResponseEntity.ok(titleMapper.mapToTitleDto(dbService.getTitle(titleId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        dbService.saveTitle(title);
    }

    @PutMapping
    public ResponseEntity<TitleDto> updateTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        Title saveTitle = dbService.saveTitle(title);
        return ResponseEntity.ok(titleMapper.mapToTitleDto(saveTitle));
    }
    @DeleteMapping(value = "{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long titleId) {
        dbService.deleteTitleById(titleId);
        return ResponseEntity.ok().build();
    }





}

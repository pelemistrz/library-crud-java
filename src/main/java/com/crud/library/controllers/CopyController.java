package com.crud.library.controllers;

import com.crud.library.domain.Copy;
import com.crud.library.domain.Title;
import com.crud.library.dto.CopyDto;
import com.crud.library.errors.CopyNotFoundException;
import com.crud.library.mappers.CopyMapper;
import com.crud.library.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/library/copies")
public class CopyController {
    private final CopyMapper copyMapper;
    private final DbService dbService;

    @Autowired
    public CopyController(CopyMapper copyMapper, DbService dbService) {
        this.copyMapper = copyMapper;
        this.dbService = dbService;
    }



    @GetMapping()
    public List<CopyDto> getCopies(){
        List<Copy> copies = dbService.getAllCopies();
        return copyMapper.mapToCopyDtoList(copies);
    }

    @GetMapping("/title")
    public List<CopyDto> getCopiesWithGivenTitle(@RequestParam String title) throws CopyNotFoundException{
        Title givenTitle = dbService.getTitleByTitle(title);
        List<Copy> copiesWithGivenTitle = dbService.getAllCopiesByTitle(givenTitle);
        return copyMapper.mapToCopyDtoList(copiesWithGivenTitle);

    }


    @GetMapping(value="{copyId}")
    public ResponseEntity<CopyDto> getCopy(@PathVariable Long copyId) throws CopyNotFoundException {
        return ResponseEntity.ok(copyMapper.mapToCopyDto(dbService.getCopy(copyId)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        System.out.println(copyDto.toString());
        Copy copy = copyMapper.mapToCopy(copyDto);
        dbService.saveCopy(copy);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CopyDto> updateCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        Copy savedCopy = dbService.saveCopy(copy);
        return ResponseEntity.ok(copyMapper.mapToCopyDto(savedCopy));
    }




    @DeleteMapping(value = "{copyId}")
    public ResponseEntity<Void> deleteCopy(@PathVariable Long copyId) throws CopyNotFoundException {
        dbService.deleteCopyById(copyId);
        return ResponseEntity.ok().build();
    }

}

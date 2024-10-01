package com.crud.library.mappers;


import com.crud.library.domain.Title;
import com.crud.library.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleMapper {
    public Title mapToTitle(final TitleDto titleDto){
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublishYear()
        );
    }
    public TitleDto mapToTitleDto(final Title title){
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublishYear()
        );
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titleList){
        return titleList.stream()
                .map(this::mapToTitleDto)
                .toList();
    }

}
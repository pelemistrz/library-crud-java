package com.crud.library.mappers;

import com.crud.library.domain.Copy;
import com.crud.library.domain.Status;
import com.crud.library.domain.Title;
import com.crud.library.dto.CopyDto;

import com.crud.library.repository.TitleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyMapper {
    private final TitleDao titleDao;

    @Autowired
    public CopyMapper(TitleDao titleDao) {
        this.titleDao = titleDao;
    }

    public Copy mapToCopy(final CopyDto copyDto) {

        Title title = titleDao.findByTitle(copyDto.getTitle());
        Status status = Status.valueOf(copyDto.getStatus());

        return new Copy(
                copyDto.getId(),
                title,
                status
        );
    }
    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getTitle().getTitle(),
                copy.getStatus().name()
        );
    }
    public List<CopyDto> mapToCopyDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .toList();
    }
}

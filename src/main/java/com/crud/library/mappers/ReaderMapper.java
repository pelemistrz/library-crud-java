package com.crud.library.mappers;


import com.crud.library.domain.Reader;
import com.crud.library.dto.ReaderDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto){
        return new Reader(
                readerDto.getId(),
                readerDto.getFirstName(),
                readerDto.getLastName(),
               readerDto.getDateOpenAccount()
        );
    }
    public ReaderDto mapToReaderDto(final Reader reader){
        return new ReaderDto(
                reader.getId(),
                reader.getFirstName(),
                reader.getLastName(),
                reader.getDateOpenAccount()
        );
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList){
        return readerList.stream()
                .map(this::mapToReaderDto)
                .toList();
    }

}

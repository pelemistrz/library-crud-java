package com.crud.library.mappers;

import com.crud.library.domain.Borrow;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Reader;
import com.crud.library.dto.BorrowDto;
import com.crud.library.repository.CopyDao;
import com.crud.library.repository.ReaderDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BorrowMapper {
    private final ReaderDao readerDao;
    private final CopyDao copyDao;




    public Borrow mapToCreateBorrow(BorrowDto borrowDto) {
        Optional<Reader> readerOpt = readerDao.findById(borrowDto.getReaderId());
        Optional<Copy> copyOpt = copyDao.findById(borrowDto.getCopyId());
        Reader reader = readerOpt.orElse(null);
        Copy copy = copyOpt.orElse(null);
        return new Borrow(
                reader,
                copy
        );
    }

    public BorrowDto mapToBorrowDto(final Borrow borrow) {
        return new BorrowDto(
                borrow.getId(),
                borrow.getReader().getId(),
                borrow.getCopy().getId(),
                borrow.getBorrowDate(),
                borrow.getReturnDate()
        );
    }
    public List<BorrowDto> mapToBorrowDtoList(final List<Borrow> borrowList) {
        return borrowList.stream()
                .map(this::mapToBorrowDto)
                .toList();
    }
}

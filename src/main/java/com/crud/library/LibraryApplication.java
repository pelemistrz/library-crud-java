package com.crud.library;

import com.crud.library.domain.Borrow;
import com.crud.library.domain.Copy;
import com.crud.library.domain.Status;
import com.crud.library.domain.Title;
import com.crud.library.dto.ReaderDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
	}

}

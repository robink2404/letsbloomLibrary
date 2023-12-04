package com.example.library.service;


import com.example.library.model.Books;
import com.example.library.repo.BookRepo;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public class LibraryService {
   public BookRepo bookRepo = new BookRepo();
    public List<Books> returnBooks(){
      return bookRepo.getListOfBooks();
    }

    public Boolean addBooks(Books book){
        return bookRepo.addBook(book);
    }

    public Boolean editBooks(String id ,Books book){
        return bookRepo.editBook(book,id);
    }
}

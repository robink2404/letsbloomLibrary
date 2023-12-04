package com.example.library.controller;


import com.example.library.model.Books;
import com.example.library.service.LibraryService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController
{
    public static LibraryService libraryService = new LibraryService();
    public static Logger log = LoggerFactory.getLogger(LibraryController.class);

    @GetMapping("/books")
    public ResponseEntity<List<Books>> retrieveBooks(){
        try{
            log.info("get api called");
             return new ResponseEntity<>(libraryService.returnBooks(), HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            log.info("exception encountered "+e.getMessage());
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));

        }
    }

    @PostMapping ("/books")
    public ResponseEntity<String> retrieveBooks(@RequestBody @Valid Books book ){
        try{
            log.info("post api called" + book.toString());
            if(libraryService.addBooks(book))
            return new ResponseEntity<>("BOOK ADDED = "+ book.getBookName(), HttpStatusCode.valueOf(200));
            else
                return new ResponseEntity<>("Duplicate Books", HttpStatusCode.valueOf(400));
        }
        catch (Exception e){
            log.info("exception encountered "+e.getMessage());
            return new ResponseEntity<>( HttpStatusCode.valueOf(400));

        }
    }

    @PutMapping ("/books")
    public ResponseEntity<String> editBooks(@RequestParam String id ,@RequestBody @Valid Books book ){
        try{
            log.info("edit api called" + book.getBookName());
            if(libraryService.editBooks(id,book))
                return new ResponseEntity<>("BOOK updated = "+ book.getBookName(), HttpStatusCode.valueOf(200));
            else
                return new ResponseEntity<>("Either Book is not present or duplicate names are provided ", HttpStatusCode.valueOf(400));
        }
        catch (Exception e){
            log.info("exception encountered "+e.getMessage());
            return new ResponseEntity<>( HttpStatusCode.valueOf(400));

        }
    }
}

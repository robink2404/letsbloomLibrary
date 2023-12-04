package com.example.library.repo;

import com.example.library.model.Books;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class BookRepo {

    HashMap<String, Books> listOfBooks = new HashMap<String, Books>();
    HashMap<Integer, Books> mockData = new HashMap<Integer, Books>();

    public List<Books> getListOfBooks(){
        ArrayList<Books> allBooks = new ArrayList<>();
        mockData.forEach((k, v)
                -> allBooks.add(v));
        return  allBooks;
    }

    public Boolean addBook(Books book){
      if(listOfBooks.containsKey(book.getBookName()))
          return false;
      book.setId(listOfBooks.size()+1);
      mockData.put(book.getId(),book);
      listOfBooks.put(book.getBookName(),book);
      return true;
    }

    public Boolean editBook(Books book,String id){
        if(!mockData.containsKey(book.getId()))
            return false;
        Books b = mockData.get(Integer.valueOf(id));
        if(listOfBooks.containsKey(book.getBookName())&&listOfBooks.get(book.getBookName()).getId()!=book.getId())
            return false;
        listOfBooks.remove(b.getBookName());
        mockData.remove(Integer.valueOf(id));
        mockData.put(Integer.valueOf(id),book);
        listOfBooks.put(book.getBookName(),book);
        return true;
    }



}

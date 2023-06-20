package com.shiv_doggar.myfirstprojextyrr;

import org.springframework.http.HttpStatus;

import java.util.*;

public class BookRepo {
    private Map<Integer,Book> bookdata=new HashMap<>();
    public void addBooki(Book book){
        bookdata.put(book.getId(),book);
    }

    public Optional<Book> getbookByid(Integer id) {
        if(bookdata.containsKey(id)){
           return  Optional.of(bookdata.get(id));
        }
        return Optional.empty();
    }

    public List<Book> getAll() {
        return new ArrayList<>(bookdata.values());
    }


    public void updateThisbook(Book book) {
        bookdata.put(book.getId(),book);
    }

    public Optional<String> deleteIt(Integer id) {
        if(bookdata.containsKey(id)){
            bookdata.remove(id);
            return Optional.of("book deleted");
        }
        return Optional.empty();
    }
}

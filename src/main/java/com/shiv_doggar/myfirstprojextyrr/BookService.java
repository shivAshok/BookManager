package com.shiv_doggar.myfirstprojextyrr;

import java.util.List;
import java.util.Optional;

public class BookService {
     private BookRepo bookRepo=new BookRepo();
     public String add(Book book){
         bookRepo.addBooki(book);
         return "book added with id "+book.getId();
     }

    public Book getbooki(Integer id) throws bookInvalid {
         Optional<Book> optionalbook=bookRepo.getbookByid(id);
         if(optionalbook.isEmpty()){
             throw new bookInvalid(id);
         }
         return optionalbook.get();
    }

    public List<Book> getAllbooks() {
         return bookRepo.getAll();
    }

    public Book getNamedbook(String name) throws RuntimeException{
         List<Book> books=bookRepo.getAll();
         for(Book book:books){
             if(book.getTitle().equals(name)){
                 return book;
             }
         }
         throw new RuntimeException("book Not found with this name");
    }


    public Book updateBook(Integer id, Integer pages) throws bookInvalid{
         Book book=getbooki(id);
         book.setPages((pages));
         bookRepo.updateThisbook(book);
         return book;
    }

    public String deleteThis(Integer id) {
         Optional<String> optionalbook=bookRepo.deleteIt(id);
         if(optionalbook.isEmpty()){
             throw new bookInvalid(id);
         }
         return optionalbook.get();
    }
}

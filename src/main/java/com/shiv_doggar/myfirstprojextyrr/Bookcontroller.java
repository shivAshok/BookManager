package com.shiv_doggar.myfirstprojextyrr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Bookcontroller {
 private BookService bookService=new BookService();
     @PostMapping("/add-new-book")
     public String addBook(@RequestBody Book book){
         String str=bookService.add(book);
         return str;
     }
  @GetMapping("/get-mybookmm")
     public ResponseEntity<?> getBook(@RequestParam Integer id){

         try{
             Book book=bookService.getbooki(id);
             return new ResponseEntity<>(book, HttpStatus.OK);
         }
         catch(bookInvalid ex){
             return new ResponseEntity<>("Booki id not found ",HttpStatus.NOT_FOUND);
         }
     }

    @GetMapping("/get-allbooks")
    public ResponseEntity<List<Book>> getAllbook(){
        return new ResponseEntity<>(bookService.getAllbooks(),HttpStatus.OK);
     }
     @GetMapping("/getbook-byname/{name}")
     public ResponseEntity<Book> getbookByname(@PathVariable String name){
       //  for(int a:bookdata.keySet()){
       //      if(bookdata.get(a).getTitle().equals(name)){
              try{
                  return  new ResponseEntity<>(bookService.getNamedbook(name),HttpStatus.OK);
              }
              catch(RuntimeException ex){
                  return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
              }
         //    }
        // }
        // return null;
     }


     @PutMapping("/update-book-page")
    public ResponseEntity<Book> updateBookpage(@RequestParam Integer id,@RequestParam Integer pages){
        // Book book=bookdata.get(id);
        // book.setPages(pages);
        // bookdata.put(id,book);
        // return book;
         try {
             Book b = bookService.updateBook(id, pages);
             return new ResponseEntity<>(b,HttpStatus.OK);
         }
         catch(bookInvalid ex){
             return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
         }
     }

     @DeleteMapping("/delete-book/{id}")
    public ResponseEntity<?> DeletebookbyId(@PathVariable Integer id){
        try{
            return new ResponseEntity<>(bookService.deleteThis(id),HttpStatus.OK);
        }
        catch(bookInvalid ex){
            return new ResponseEntity<>("book not present with this id",HttpStatus.NOT_FOUND);
        }
     }

}

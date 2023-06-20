package com.shiv_doggar.myfirstprojextyrr;

public class bookInvalid extends RuntimeException{
    bookInvalid(Integer id){
        super("book is not present with id"+id);
    }
}

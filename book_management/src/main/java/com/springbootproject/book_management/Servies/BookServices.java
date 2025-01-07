package com.springbootproject.book_management.Servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.book_management.Entity.Book;
import com.springbootproject.book_management.Repository.BookRepository;

@Service
public class BookServices {
    
    @Autowired
    private BookRepository Br;

    public void save(Book book){
        Br.save(book);
    }

    public List<Book> getAllBooks(){
        return Br.findAll();
        
    }
    public Book getBookById(int id){
        return Br.findById(id).get();

    }

    public void deleteBookById(int id){
        Br.deleteById(id);

    }
    
}

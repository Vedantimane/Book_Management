package com.springbootproject.book_management.Servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.book_management.Entity.MyBookList;
import com.springbootproject.book_management.Repository.MyBookListRepository;

@Service
public class MyBookListService {

    @Autowired
    private MyBookListRepository Mbr;

    public void saveMyBooks(MyBookList mybooklist){
        Mbr.save(mybooklist);

    }
    public List<MyBookList> getAllMyBooks(){
        return Mbr.findAll();
        
    }

    public void deletebyId(int id){
        Mbr.deleteById(id);
    }


    
}

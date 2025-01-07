package com.springbootproject.book_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.book_management.Entity.MyBookList;

@Repository
public interface MyBookListRepository  extends JpaRepository<MyBookList ,Integer>{
    
}

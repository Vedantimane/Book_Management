package com.springbootproject.book_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbootproject.book_management.Entity.Book;
import com.springbootproject.book_management.Entity.MyBookList;
import com.springbootproject.book_management.Servies.BookServices;
import com.springbootproject.book_management.Servies.MyBookListService;

import org.springframework.web.bind.annotation.RequestMapping;








@Controller
public class BookController {


    @Autowired
    private BookServices Bs;

    @Autowired
    private MyBookListService Mbs;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "book_register"; // This should correspond to the view name (e.g., a Thymeleaf template).
    }

    @GetMapping("/available_book")
    public ModelAndView getAllBooks() {
        List<Book>list=Bs.getAllBooks();
        ModelAndView mav=new ModelAndView();
        mav.setViewName("available_book");
        mav.addObject("book", list);
        return mav;

    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        Bs.save(book);
        
        return "redirect:/available_book";
    }
    
    @GetMapping("/myBooks")
    public String getMyBooks(Model model) {
        List<MyBookList>list =Mbs.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b=Bs.getBookById(id);
        MyBookList myBookList= new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        Mbs.saveMyBooks(myBookList);
        return "redirect:/myBooks";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book b=Bs.getBookById(id);
        model.addAttribute("book", b);
        return "BookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        Bs.deleteBookById(id);
        return "redirect:/available_book";


    }
    
    }

    
    
    
    
    
    
    


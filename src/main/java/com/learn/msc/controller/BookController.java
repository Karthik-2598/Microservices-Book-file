package com.learn.msc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.learn.msc.model.Book;
import com.learn.msc.service.BookService;

@RestController

public class BookController {
@Autowired
BookService bookService;

@GetMapping("/")
public String home() {
	return "Book service home page";
	
}
@GetMapping("/addBook")
public String addBook(int id,String name,String author) {
	System.out.print("book controller called");
	bookService.addBook(Book.builder().id(id).name(name).author(author).build());
	return "book added";
}
@GetMapping("/getbooks")
public String getAll() {
	Gson gson=new Gson();
	//convert list to json
	
	String json = gson.toJson(bookService.getAll());
	return json;
}
@GetMapping("/deletebook")
public String deleteBook(int id) {
	bookService.deleteBook(id);
	return "book deleted";
}
}

package com.Joey.CCCS425A2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.Joey.CCCS425A2.model.Book;

@Service
public class BookServiceImpl implements BookService {

	Map<Long, Book> books = new HashMap<>();
	long currentId = 5;

	public BookServiceImpl() {
		init();
	}

	void init() {
		Book book1 = new Book();
		book1.setId(1); // set Hardcoded data here. maybe use a for loop
		book1.setTitle("Ulysses");
		books.put(book1.getId(), book1);

		Book book2 = new Book();
		book2.setId(2); // set Hardcoded data here. maybe use a for loop
		book2.setTitle("Don Quixote");
		books.put(book2.getId(), book2);

		Book book3 = new Book();
		book3.setId(3); // set Hardcoded data here. maybe use a for loop
		book3.setTitle("One Hundred Years of Solitude");
		books.put(book3.getId(), book3);

		Book book4 = new Book();
		book4.setId(4); // set Hardcoded data here. maybe use a for loop
		book4.setTitle("The Great Gatsby");
		books.put(book4.getId(), book4);

		Book book5 = new Book();
		book5.setId(5); // set Hardcoded data here. maybe use a for loop
		book5.setTitle("Moby Dick");
		books.put(book5.getId(), book5);
	}

	@Override
	public List<Book> getBooks() { // GET ALL BOOKS
		Collection<Book> results = books.values();
		List<Book> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Book getBooks(long id) {
		return books.get(id);
	}

	@Override
	public Response createBook(Book book) {
		book.setId(++currentId);
		books.put(book.getId(), book);
		return Response.ok(book).build();
	}

	@Override
	public Response updateBook(Book book) {
		Book currentBook = books.get(book.getId());

		Response response;
		if (currentBook != null) {
			books.put(book.getId(), book);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deleteBook(long id) {
		Book currentBook = books.get(id);

		Response response;
		if (currentBook != null) {
			books.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}
}

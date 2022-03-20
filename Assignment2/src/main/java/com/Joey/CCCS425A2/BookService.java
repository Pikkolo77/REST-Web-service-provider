package com.Joey.CCCS425A2;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.Joey.CCCS425A2.model.Book;

@Path("/bookservice")
public interface BookService {

	@Path("/books")
	@GET
	List<Book> getBooks();
	
	@Path("/books/{id}") //GET METHOD TO RETURN DATA BASED ON ID
	@GET
	Book getBooks(@PathParam("id") long id);
	
	@Path("/books") //POST METHOD TO ADD A NEW BOOK
	@POST
	Response createBook(Book book);
	
	@Path("/books") //POST METHOD TO ADD A NEW BOOK
	@PUT
	Response updateBook(Book book);
	
	@Path("/books/{id}") //DELETE METHOD
	@DELETE
	Response deleteBook(@PathParam("id") long id);
	
	
}

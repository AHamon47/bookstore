package api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.BookDao;
import entity.Book;

@Path("/bookstore")
public class BookstoreAPI {
	
		@GET
		@Path("/getbooks") // -> chemin vers notre api http://localhost:8080 + rest-lesson + /api/ + 
	    @Produces({ MediaType.APPLICATION_JSON }) // -> renvoyé
		public ArrayList<Book> getBooks() {		
			return (ArrayList<Book>) BookDao.getBooks();
		}
		
		@GET
		@Path("/getbooks/{id}")
		@Produces({ MediaType.APPLICATION_JSON })
		public Book getBook(@PathParam("id") int id) {
			return BookDao.getBooks().get(id);
		}

		@GET
		@Path("/postbook/{title}/{author}/{date}/{price}")
		@Produces({MediaType.APPLICATION_JSON})
		public Book myBook(@PathParam("title") String title, @PathParam("author") String author, @PathParam("date") String date, @PathParam("price") double price) {
			Book newBook = new Book(title, author, date, price);
			newBook.saveBook();
			return newBook;
		}
}
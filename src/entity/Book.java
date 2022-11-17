package entity;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dao.BookDao;

@ManagedBean(name = "book")
@Entity(name = "Book")
@Table(name = "books")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id = 0;
	@Column(name = "Title")
	private String title;
	@Column(name = "Author")
	private String author;
	@Column(name = "PublicationDate")
	private String publicationDate;
	@Column(name = "Price")
	private double price;

	public Book(String title, String author, String publicationDate, double price) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.price = price;
	}

	public Book() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationDate=" + publicationDate
				+ ", price=" + price + "]";
	}
	
	public void saveBook() {
		BookDao.saveBook(this);
	}
	
	public void updateBook() {
		BookDao.updateBook(this);
	}
	
	public void deleteBook() {
		BookDao.deleteBook(this);
	}
}

package dao;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entity.Book;
import util.HibernateUtil;

@ManagedBean(name = "bookdao")
public class BookDao {
	
	public static void saveBook(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.persist(b);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
	}
	
	public static Book getBook(int id) {
		Book b = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			b = session.get(Book.class, id);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
		return b;
	}
	
	public static void updateBook(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(b);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
	}
	
	public static void deleteBook(Book b) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Book del = session.get(Book.class, b.getId());
			session.delete(del);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
	}
	
	public static void deleteBook(int i) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Book del = session.get(Book.class, i);
			session.delete(del);
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
	}
	
	public static List<Book> getBooks() {
		List<Book> books = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Query<Book> query = session.createQuery("SELECT b FROM Book b", Book.class);
			books = (List<Book>) query.list();
			transaction.commit();
		}
		catch (Exception e) {
			System.out.println("Cannot complete transaction. Error: " + e);
			transaction.rollback();
		}
		session.close();
		return books;
	}
}

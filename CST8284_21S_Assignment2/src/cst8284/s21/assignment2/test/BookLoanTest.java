package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.s21.assignment2.Book;
import cst8284.s21.assignment2.BookLoan;
import cst8284.s21.assignment2.User;

public class BookLoanTest {
	
	private static final String DEFAULT_FIRSTNAME = "Willis";
	private static final String DEFAULT_LASTNAME = "Robert";
	private static final String DEFAULT_ADDRESS = "345 Woodroffe Avenue, Ottawa";
	private static final int DEFAULT_AGE = 21;
	private static final String DEFAULT_TITTLE = "Android Cookbook";
	private static final String DEFAULT_AUTHOR = "Ian F. Darwin";
	private static final String DEFAULT_POD = "2012";
	private static final String DEFAULT_ISBN = "1449335799";
	private static final String DEFAULT_DUE_DATE = "2021-12-31";
	
	User user;
	Book book;
	BookLoan bookLoan;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User(DEFAULT_FIRSTNAME,DEFAULT_LASTNAME,DEFAULT_ADDRESS,DEFAULT_AGE);
		book = new Book(DEFAULT_TITTLE,DEFAULT_AUTHOR,DEFAULT_ISBN, DEFAULT_POD);
		bookLoan = new BookLoan(user,book,DEFAULT_DUE_DATE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBookLoan_True() {
		String isbn = bookLoan.getBook().getIsbnNumber();
		assertTrue(isbn.equals(DEFAULT_ISBN));
	}

	@Test
	public void testBookLoan_False() {
		String isbn = bookLoan.getBook().getIsbnNumber();
		assertFalse(isbn.equals(" "));
	}
	
	@Test
	public void testGetUser_True() {
		User user1 = bookLoan.getUser();
		assertTrue(user.equals(user1));
	}

	@Test
	public void testGetUser_False() {
		User user1 = new User("","","");
		BookLoan bookLoan2 = new BookLoan(user1,null,null);
		assertFalse(user.equals(bookLoan2.getUser()));
	}

	@Test
	public void testSetUser_True() {
		User user1 = new User("","","");
		bookLoan.setUser(user1);
		assertTrue(user1.equals(bookLoan.getUser()));
	}

	@Test
	public void testSetUser_False() {
		User user1 = new User("","","");
		bookLoan.setUser(user);
		assertFalse(user1.equals(bookLoan.getUser()));
	}

	@Test
	public void testGetBook_True() {
		Book book1 = bookLoan.getBook();
		assertTrue(book.equals(book1));
	}

	@Test
	public void testGetBook_False() {
		Book book1 = new Book("","","","");
		BookLoan bookLoan1 = new BookLoan(null,book1,null);
		assertFalse(book.equals(bookLoan1.getBook()));
	}
	
	@Test
	public void testSetBook_True() {
		Book book1 = new Book("","","","");
		bookLoan.setBook(book1);
		assertTrue(book1.equals(bookLoan.getBook()));
	}
	
	@Test
	public void testSetBook_False() {
		Book book1 = new Book("","","","");
		bookLoan.setBook(book);
		assertFalse(book1.equals(bookLoan.getBook()));
	}

	@Test
	public void testGetDueDate_True() {
		String dueDate = bookLoan.getDueDate();
		assertTrue(dueDate.equals(DEFAULT_DUE_DATE));
	}
	
	@Test
	public void testGetDueDate_False() {
		String dueDate = bookLoan.getDueDate();
		String dueDate2 = "2020-11-01";
		assertFalse(dueDate.equals(dueDate2));
	}

	@Test
	public void testSetDueDate_True() {
		String dueDate2 = "2020-11-01";
		bookLoan.setDueDate(dueDate2);
		assertTrue(dueDate2.equals(bookLoan.getDueDate()));
	}

	@Test
	public void testSetDueDate_False() {
		String dueDate2 = "2020-11-01";
		bookLoan.setDueDate(DEFAULT_DUE_DATE);
		assertFalse(dueDate2.equals(bookLoan.getDueDate()));
	}
	
	@Test
	public void testGetBookLoan_True() {
		BookLoan bookLoan1 = bookLoan.getBookLoan();
		assertTrue(bookLoan.equals(bookLoan1));
	}

	@Test
	public void testGetBookLoan_False() {
		BookLoan bookLoan1 = new BookLoan(null,null,null);
		assertFalse(bookLoan.equals(bookLoan1.getBookLoan()));
	}
	
	@Test
	public void testToString_True() {
		String str = bookLoan.toString();
		assertTrue(str.contains(DEFAULT_DUE_DATE));
	}

	@Test
	public void testToString_False() {
		String str = bookLoan.toString();
		assertFalse(str.contains("2020-11-01"));
	}
	
	@Test
	public void testEqualsObject_True() {
		BookLoan bookLoan1 = new BookLoan(user,book,DEFAULT_DUE_DATE);
		assertTrue(bookLoan.equals(bookLoan1));
	}

	@Test
	public void testEqualsObject_False() {
		BookLoan bookLoan1 = new BookLoan(null,null,null);
		assertFalse(bookLoan.equals(bookLoan1));
	}
}

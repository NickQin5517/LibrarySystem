package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.s21.assignment2.Book;

public class BookTest {
	private static final String DEFAULT_TITTLE = "Android Cookbook";
	private static final String DEFAULT_AUTHOR = "Ian F. Darwin";
	private static final String DEFAULT_POD = "2012";
	private static final String DEFAULT_ISBN = "1449335799";
	Book book;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 book = new Book (DEFAULT_TITTLE,DEFAULT_AUTHOR,DEFAULT_ISBN, DEFAULT_POD);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBook_True() {
		String isbn = book.getIsbnNumber();
		assertTrue(isbn.equals(DEFAULT_ISBN));
	}
	
	@Test
	public void testBook_False() {
		String isbn = book.getIsbnNumber();
		assertFalse(isbn.equals(""));
	}

	@Test
	public void testGetTitle_True() {
		String title = book.getTitle();
		assertTrue(title.equals(DEFAULT_TITTLE));
	}
	
	@Test
	public void testGetTitle_False() {
		String title = book.getTitle();
		assertFalse(title.equals(""));
	}

	@Test
	public void testSetTitle_True() {
		book.setTitle(" ");
		String title = book.getTitle();
		assertTrue(title.equals(" "));
	}

	@Test
	public void testSetTitle_False() {
		book.setTitle(DEFAULT_TITTLE);
		String title = book.getTitle();
		assertFalse(title.equals(" "));
	}
	
	@Test
	public void testGetAuthor_True() {
		String author = book.getAuthor();
		assertTrue(author.equals(DEFAULT_AUTHOR));
	}

	@Test
	public void testGetAuthor_False() {
		String author = book.getAuthor();
		assertFalse(author.equals(""));
	}
	
	@Test
	public void testSetAuthor_True() {
		book.setAuthor(" ");
		String author = book.getAuthor();
		System.out.println(author);
		assertTrue(author.equals(" "));
	}
	
	@Test
	public void testSetAuthor_False() {
		book.setTitle(DEFAULT_AUTHOR);
		String title = book.getTitle();
		assertFalse(title.equals(" "));
	}

	@Test
	public void testGetPublicationDate_True() {
		String pod = book.getPublicationDate();
		assertTrue(pod.equals(DEFAULT_POD));
	}

	@Test
	public void testGetPublicationDate_False() {
		String pod = book.getPublicationDate();
		assertFalse(pod.equals(""));
	}

	@Test
	public void testSetPublicationDate_True() {
		book.setPublicationDate(" ");
		String pod = book.getTitle();
		assertFalse(pod.equals(" "));
	}

	@Test
	public void testSetPublicationDate_False() {
		book.setPublicationDate(DEFAULT_POD);
		String pod = book.getTitle();
		assertFalse(pod.equals(" "));
	}
	@Test
	public void testGetIsbnNumber_True() {
		String isbn = book.getIsbnNumber();
		assertTrue(isbn.equals(DEFAULT_ISBN));
	}

	@Test
	public void testGetIsbnNumber_False() {
		String isbn = book.getIsbnNumber();
		assertFalse(isbn.equals(" "));
	}
	
	@Test
	public void testSetIsbnNumber_True() {
		book.setIsbnNumber(" ");
		String isbn = book.getIsbnNumber();
		assertTrue(isbn.equals(" "));
	}

	@Test
	public void testSetIsbnNumber_False() {
		book.setIsbnNumber(DEFAULT_ISBN);
		String isbn = book.getIsbnNumber();
		assertFalse(isbn.equals(" "));
	}

	@Test
	public void testGetBook_True() {
		Book secondBook = book.getBook();
		assertTrue(book.equals(secondBook));
	}

	@Test
	public void testGetBook_False() {
		Book secondBook = new Book("","","","");
		assertFalse(book.equals(secondBook.getBook()));
	}
	
	@Test
	public void testToString_True() {
		String str = book.toString();
		assertTrue(str.contains(DEFAULT_ISBN));
	}

	@Test
	public void testToString_False() {
		Book secondBook = new Book ("","","","");
		String str = book.toString();
		String str2 = secondBook.toString();
		assertFalse(str.equals(str2));
		
	}

	@Test
	public void testEqualsObject_True() {
		Book secondBook = new Book(DEFAULT_TITTLE,DEFAULT_AUTHOR,DEFAULT_ISBN,DEFAULT_POD);
		assertTrue(book.equals(secondBook));
	}
	
	@Test
	public void testEqualsObject_False() {
		Book secondBook = new Book ("","","","");
		assertFalse(book.equals(secondBook));
	}

}

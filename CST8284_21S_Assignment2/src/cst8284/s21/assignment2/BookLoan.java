package cst8284.s21.assignment2;
/**
 * This class can used for creating BookLoan object through constructor,
 *  getters and setters,then return BookLoan type.
 * @author Ning Qin
 * @since 2021-06-11
 *Class Name: Object Oriented Programming
 *Author Name: Ning Qin
 *Assignment Name: Java Assignment 2
 *Section Number: CST8284_302
 *Date: 18 July 2021
 */

public class BookLoan {
	private User user;
	private Book book;
	private String dueDate;
	
	//BookLoan constructor that take in User, Book, String as parameters.
	//BookLoan(user: User, book: Book, pubDate: String)	
	public BookLoan(User user,Book book,String dueDate) {
		setUser(user);
		setBook(book);
		setDueDate(dueDate);
	}
	//getter for user
	//getUser():User		
	public User getUser() {
		return user;
	}
	//setter for user
	//setUser(user: User):void	
	public void setUser(User user) {
		this.user = user;	
	}
	//getter for book
	//getBook():Book		
	public Book getBook() {
		return book;
	}
	//setter for book
	//setBook(book: Book):void	
	public void setBook(Book book) {
		this.book = book;	
	}
	//getter for dueDate
	//getDueDate():String	
	public String getDueDate() {
		return dueDate;
	}
	//setter for dueDate
	//setDueDate(dueDate: String):void	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;	
	}
	//getter for type BookLoan
	//getBookLoan():BookLoan		
	public BookLoan getBookLoan() {
		return this;
	}
	//return BookLoan object as a String type
	//toString():String	
	@Override
	public String toString() {
		return "************User name: " + user.getFirstName()+" "+user.getLastName()+"\r\n"+
				"************Title: " + book.getTitle()+"\r\n"+
				"************Author: " + book.getAuthor()+"\r\n"+
				"************ISBN: " + book.getIsbnNumber()+"\r\n"+
				"************Due date: " +getDueDate();
	}
	//equals(obj:Object):boolean
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BookLoan && obj != null) {
			BookLoan cmpObj = (BookLoan) obj;
			return (this.getUser().equals(cmpObj.getUser())&&this.getBook().equals(cmpObj.getBook())
					&&this.getDueDate().equals(cmpObj.getDueDate())) ? true : false;
		}
		else {
			return false;
		}
		
	}
	

}

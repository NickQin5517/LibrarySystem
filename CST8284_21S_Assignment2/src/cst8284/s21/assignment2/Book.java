package cst8284.s21.assignment2;
/**
 * This class can used for creating Book object through constructor,
 *  getters and setters,then return Book type.
 * @author Ning Qin
 * @since 2021-06-11

 */

public class Book {
	
	private String title;
	private String author;
	private String publicationDate;
	private String isbnNumber;

	//Book constructor that take in String, String, String, String as parameters.
	//Book(title: String, author: String, isbn: String, pubDate: String)
	public Book(String title, String author,String isbn,String pubDate) {
		setTitle(title);
		setAuthor(author);
		setPublicationDate(pubDate);
		setIsbnNumber(isbn);		
	}
	//getter for title
	//getTitle():String	
	public String getTitle(){
		return title;
	}
	//setter for title
	//setTitle(title: String):void	
	public void setTitle(String title) {
		this.title = title;
	}
	//getter for author
	//getAuthor():String		
	public String getAuthor(){
		return author;
	}
	//setter for author
	//setAuthor(author: String):void		
	public void setAuthor(String author) {
		this.author = author;
	}
	//getter for publicationDate
	//getPublicationDate():String		
	public String getPublicationDate(){
		return publicationDate;
	}
	//setter for publicationDate
	//setPublicationDate(publicationDate: String):void	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}	
	//getter for isbnNumber
	//getIsbnNumber():String	
	public String getIsbnNumber(){
		return isbnNumber;
	}
	//setter for isbnNumber
	//setIsbnNumber(isbnNumber: String):void		
	public void setIsbnNumber(String isbnNumber) {
		this.isbnNumber = isbnNumber;
	}
    
	//getter for type Book
	//getBook():Book	
	public Book getBook() {
		return this;
	}
	//return Book object as a String type
	//toString():String	
	@Override
	public String toString() {
		
		return "************Title: " + getTitle()+"\r\n"+
				"************Author: " + getAuthor()+"\r\n"+
				"************Publication Year: " + getPublicationDate()+"\r\n"+
				"************ISBN: " + getIsbnNumber();
		
	}
	//equals(obj:Object):boolean
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book && obj != null) {
			Book cmpObj = (Book) obj;
			return (this.getIsbnNumber().equals(cmpObj.getIsbnNumber())&&this.getTitle().equals(cmpObj.getTitle())
					&&this.getAuthor().equals(cmpObj.getAuthor())&&this.getPublicationDate().equals(cmpObj.getPublicationDate())) ? true : false;
		}
		else {
			return false;
		}
		
	}
	

}

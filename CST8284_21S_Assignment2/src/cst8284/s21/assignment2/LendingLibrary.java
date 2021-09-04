package cst8284.s21.assignment2;
import java.util.ArrayList;

/**
 * This class can save the data that user input from LendingLibraryController() class to objects.
 * Also create User, Book and BookLoan objects and save all information to array, and 
 * provide methods for user to interact with database.
 * @author Ning Qin
 * @since 2021-06-11

 */

public class LendingLibrary {
	
	private static final int MAX_LOAN_PER_USER = 2;	
	
	private ArrayList<Book> bookReg = new ArrayList<Book>();
	private ArrayList<User> userReg = new ArrayList<User>();
	private ArrayList<BookLoan> loanReg = new ArrayList<BookLoan>();
	
	//default constructor
	//LendingLibrary()
	public LendingLibrary() {
		
	}

	//save user object to ArrayList<User> userReg
	//addUser(u: User): boolean
	public boolean addUser(User u) {		
			if(!userReg.contains(u)) {
				userReg.add(u);  
	            return true;
			}
			else {
				return false;
			}						
				
	}
	//add book object to ArrayList<Book> bookReg
	//addBook(u: Book): boolean
	public boolean addBook(Book u) {
		boolean flag = true;
		for(int i = 0; i< bookReg.size(); i++) {
	    	if(bookReg.get(i).getIsbnNumber().equals(u.getIsbnNumber())) {	    	   
	    	    flag = false;
	    	    break;
	    	}
		}
		if(flag) {
			bookReg.add(u);
			return true;
		}else {
			return false;
		}
			
	}
    //add Loan object to ArrayList<BookLoan> loanReg
	//addLoan(l: BookLoan): boolean
	public boolean addLoan(BookLoan l) {
		if(!loanReg.contains(l)) {
			loanReg.add(l);	    	
	    	 return true;
	    }
	    else {			
			return false;
		}			
	}
	//comparing firstName and lastName to object inside userReg to finding user
	//findUser(firstName:String, lastName:String): User
	public User findUser(String firstName,String lastName) {
		
		int i = 0;
	    boolean flag = false;
		for ( ;i <userReg.size();i++) {  
			if(userReg.get(i).getFirstName().equals(firstName)&&userReg.get(i).getLastName().equals(lastName)) {
				flag = true;			
				break;
			}							
		}	
		return flag ? userReg.get(i): null;   //return the found user
	}
	//comparing isbnNumber to object inside bookReg to finding book
	//findBook(isbnNumber:String):Book
	public Book findBook(String isbnNumber) {
		int i = 0;
	    boolean flag = false;
		for ( ;i <bookReg.size();i++) {
			if(bookReg.get(i).getIsbnNumber().equals(isbnNumber)) {
				flag = true;			
				break;
			}							
		}	
		return flag ? bookReg.get(i): null;   //return the found book
	}
	//comparing isbnNumber to object inside loanReg to finding BookLoan
	//findLoan(isbnNumber:String):BookLoan
	public BookLoan findLoan(String isbnNumber) {
		int i = 0;
	    boolean flag = false;
		for ( ;i <loanReg.size();i++) {
			if(loanReg.get(i).getBook().getIsbnNumber().equals(isbnNumber)) {
				flag = true;
				break;
			}						
		}
		return flag ? loanReg.get(i): null;            //return the found bookloan		
	}
	//delete a user by firstname and lastname from arraylist userReg
	//deleteUser(firstNume:String,lastName:String):boolean
	public boolean deleteUser(String firstNume, String lastName) {
		int i = 0;
	    boolean flag = false;
		for ( ;i <loanReg.size();i++) {
			if(loanReg.get(i).getUser().getFirstName().equals(firstNume)&&loanReg.get(i).getUser().getLastName().equals(lastName)) {
				flag = true;
				break;
			}						
		}
		return findUser(firstNume,lastName) != null && !flag ? true : false;
		
	}
	//delete a book by isbnNumber from arraylist bookReg
	//deleteBook(isbnNumber:String):boolean
	public boolean deleteBook(String isbnNumber) {
		return findBook(isbnNumber) != null && findLoan(isbnNumber) == null ? true : false;
	}
	//delete a bookloan by isbnNumber from arraylist loanReg
	//deleteLoan(isbnNumber:String):boolean
	public boolean deleteLoan(String isbnNumber) {
		return findLoan(isbnNumber) != null ? true : false;
		
	}
	//check if a user can borrow more book, a user can not borrow more than two books 
	//userCanBorrow(u: User):boolean
	public boolean userCanBorrow(User u) {
		int counter = 0;               
		for(int i = 0;i<loanReg.size();i++ ) {
			if((loanReg.get(i).getUser().getFirstName()).equals(u.getFirstName())&&(loanReg.get(i).getUser().getLastName()).equals(u.getLastName())) {
				counter++;             //add 1 to counter every time a user occurs in array
			}
		}
		return counter<MAX_LOAN_PER_USER ? false : true;		
	}
	//check if a book has been borrowed to a user
	//isBookLoaned(b:Book):boolean
	public boolean isBookLoaned(Book b) {
		int counter = 0;
		for(int i = 0;i<loanReg.size();i++ ) {
			if(loanReg.get(i).getBook().getIsbnNumber().equals(b.getIsbnNumber())) {
				counter++;           //add 1 to counter every time a book occurs in array
			}
		}
		return counter==0 ? false : true;
	}

	//getter of userReg
	//getUserReg():User[]
	public ArrayList<User> getUserReg() {      
		return userReg;
	}

	//getter of bookReg
	//getBookReg():Book[]
	public ArrayList<Book> getBookReg() {
		return bookReg;
	}
	//getter of loanReg
	//getLoanReg():BookLoan[]
	public ArrayList<BookLoan> getLoanReg() {
		return loanReg;
	}

	
	
}

package cst8284.s21.assignment2;

/**
 * This class include all methods that could be called by user in AppDriver() class.
 * It also allow a user to input the data that are corresponding the chosen option and 
 * save and browse all input information by call methods in LendingLibrary class by initiate
 * a LendingLibrary object bookLib.
 * @author Ning Qin
 * @since 2021-06-11

 */

import java.util.Scanner;

public class LendingLibraryController {
	private static LendingLibrary bookLib = new LendingLibrary();
	private static Scanner input = new Scanner(System.in);
	
	//default constructor
	//LendingLibraryController()
	public LendingLibraryController() {
		
	}	
    /*make user input first name, last name, age and address, after age validated ,
     *object call method addUser() to save it. */
	//addUser(): void 
	public void addUser(){
		int id =0;
		System.out.println("New User Entry");
		String firstName = getResponseTo("First Name");		 //input first name 
		String lastName = getResponseTo("Last Name");		 //input last name 
		int age;
        do {                             //check age through a do while loop
		System.out.println("Age");
		age = input.nextInt();           //input age 
		input.nextLine();                // Remove CRLF from input buffer
        }while(!isValidNumber(age));    //validate age by calling isValidNumber() method
		String address = getResponseTo("User address");	
		User user = new User(id, firstName, lastName, address, age);
		if(bookLib.addUser(user)) {
			System.out.println("User was added");			
		}else {
			System.out.println("The user has already existed");
		}		                                            
	 }
    //change user's address by searching first name and last name
    //changeUser(): void 
    public void changeUser(){
    	System.out.println("Change User");		
		String firstName = getResponseTo("First Name");			
		String lastName = getResponseTo("Last Name");	
    	User user = bookLib.findUser(firstName,lastName);              //comparing it with calling findUser() method
    	if (user != null) {                                            //find if the user existed in the system
    		System.out.println(user);
        	System.out.println(" ");
        	String newAddress = getResponseTo("\"Please enter a new address! \"");
            user.setAddress(newAddress);                               // set the new address
            System.out.println("Address has been changed successfully! ");
    	}else {
    		System.out.println("User not found!");
    	}

		
	}
    //find user by inputting first name and last name
    //findUser(): void
    public void findUser(){
    	System.out.println("Find User");		
		String firstName = getResponseTo("First Name");			
		String lastName = getResponseTo("Last Name");
    	User user = bookLib.findUser(firstName,lastName);
    	if (user != null) {
    		System.out.println(user);                  //output the user if found

    	}else {
    		System.out.println("User not found!");
    	}
		
	}
    
    //list all users in the system through print out every element from ArrayList<User> userReg
    //listUsers(): void
    public void listUsers(){
    	//ArrayList<User> user = bookLib.getUserReg();             //get the existed user arraylist
    	for (int i = 0; i<bookLib.getUserReg().size(); i++) {
    	 System.out.println("User #"+(i+1));
    	 System.out.println(bookLib.getUserReg().get(i));                    //print elements by for loop
    	 System.out.println(" ");
    	}
		
	}
    /***************************
     * Reference
     * Title: <Java String - See if a string contains only numbers and not letters>
     * Author: <Guillaume Polet> 
     * Availability: <https://stackoverflow.com/questions/10575624/java-string-see-if-a-string-contains-only-numbers-and-not-letters>
     * *************************/
    //input book data 
    //addBook(): void
    public void addBook(){
    	System.out.println(" ");
    	System.out.println("New Book Entry");
    	System.out.println(" ");
    	String title = getResponseTo("Title: ");
    	String author = getResponseTo("Author: ");
    	String pubDate = getResponseTo("Publication date (year in NNNN format): "); 
    	boolean flag1 = checkDate(pubDate); 	       //validate publication date   			
        if(flag1) {
        	String isbnNumber = getResponseTo("ISBN number (10 digits): ");     
    	    if(verifyISBNNumber(isbnNumber)) {                            //validate isbnNumber
    	         Book newbook = new Book(title,author,isbnNumber,pubDate);     
    	         if(bookLib.addBook(newbook)) {
    	    	      System.out.println("Book was added");
    	          }
    	         else {
    	    	 System.out.println("The book has already existed!");
    	         }
    	    }
    	    else {
    		     System.out.println("The ISBNNumber is not valid!");    		
    	    }
        }
	}
    //change book information by searching isbnNumber
    //changeBook(): void
    public void changeBook(){
    	System.out.println("Change Book");
    	String isbn = getResponseTo("Please enter ISBN: ");
    	Book book = bookLib.findBook(isbn);                         //retrieve book object
    	if(book != null) { 
    		System.out.println(book);
    		System.out.println("Please enter 1 to update author!");             //provide user a menu to choose the part that
        	System.out.println("Please enter 2 to update title!");              //need to be edited
        	System.out.println("Please enter 3 to update publicationdate!");
        	System.out.println("Please enter any key to quit update!");
        	String choice = input.nextLine();
        	final String UPT_AUT = "1";
        	final String UPT_TIT= "2";
        	final String UPT_PUB= "3";
        	if(choice.equals(UPT_AUT)) {
        	   String author = getResponseTo("Please enter new author!");
        	   book.setAuthor(author);
        	   System.out.println("Author has been updated succeffuly!");
        	}
        	else if (choice.equals(UPT_TIT)) {
        	   String title = getResponseTo("Please enter new title!");
        	   book.setTitle(title);
        	   System.out.println("Title has been updated succeffuly!");
        	}
        	else if(choice.equals(UPT_PUB)){
        	   String publicationdate = getResponseTo("Please enter new publicationdate!");
        	   if(checkDate(publicationdate)) {
        	     book.setPublicationDate(publicationdate);
        	     System.out.println("Publicationdate has been updated succeffuly!");
        	   }
        	}
    	}
    	else {
    		System.out.println("The book is not found!");                      //notice user if not found
    	}       	
	}
    //find book by isbnnumber
    //findBook(): void
    public void findBook(){
    	
    	System.out.println("Find Book");
    	String isbn = getResponseTo("Please enter ISBN: ");                //input isbnnumber
    	Book book = bookLib.findBook(isbn);                                //call findBook method to search the book
    	if(book != null) { 
    		System.out.println(book);                                      //print out book if found
    	}
    	else {
    		System.out.println("The book is not found!"); 
    	}//notice user if not found
	}
    //list all book existed in the system by a loop
	//listBooks(): void
    public void listBooks(){
    	for (int i = 0; i<bookLib.getBookReg().size(); i++) {   
    		System.out.println("Book #"+(i+1));
       	 System.out.println(bookLib.getBookReg().get(i));
       	 System.out.println(" ");
       	}		
	}
    //input a bookloan information and validated it, then save it
    //addBookLoan(): void
    public void addBookLoan(){
    	System.out.println("New Loan Entry");
    	String firstName = getResponseTo("User first name: ");
    	String lastName = getResponseTo("User last name: ");
    	String isbnNumber = getResponseTo("Book isbn number: ");
    	User user = bookLib.findUser(firstName,lastName);
    	Book book = bookLib.findBook(isbnNumber);
    	String dueDate;
    	BookLoan newBookLoan = new BookLoan(null,null,null);
    	boolean flag = false;   	
    	if(user == null) {                                                  //validate if input user exists                   
    		System.out.println("Could not find a user with this name!");   	
    		flag = true;
    	}
    	else if(book == null) {                                             //check if the book exists
    		System.out.println("Could not find a book with this isbn!");
    		flag = true;
    	}
       else if(bookLib.userCanBorrow(user)){                                //validate a user can not borrow more than two books
    		System.out.println("The user can not borrow more than two books!");   
    		flag = true;   		
    	} 
    	else if(bookLib.isBookLoaned(book)){                                  //validate if a book has been borrowed
    		System.out.println("The book has been borrowed!");
    		flag = true;  
    	} 
    	else if(flag==false){	
    		dueDate = getResponseTo("Due date (format yyyy-mm-dd)");
    		newBookLoan = new BookLoan(user,book,dueDate);                    //create a new BookLoan object and call BookLoan constructor
    		if(bookLib.addLoan(newBookLoan)) {
    			System.out.println("BookLoan was added");
    			System.out.println(newBookLoan.getBookLoan());
    		}else {
    			System.out.println("The BookLoan has already existed!");
    		}  		
    	}	
   	}
   	// change BookLoan data by isbnNumber
    //changeBookLoan(): void
    public void changeBookLoan(){
    	String isbnNumber = getResponseTo("Please anter a ISBN number:");
    	BookLoan bookLoan = bookLib.findLoan(isbnNumber);                      //retrieve bookloan
    	if(bookLoan != null) { 
    		System.out.println(bookLoan);
        	String newDueDate = getResponseTo("Please enter a new due date! ");
    		bookLoan.setDueDate(newDueDate);                                   //save changes
    		System.out.println("Address has been changed successfully! ");
    	}
    	else {
    		System.out.println("No book loan found with this isbn number.");
    	}    		
   	}
    //search a bookloan using isbnNumber
    //findBookLoan(): void
    public void findBookLoan(){
    	String isbnNumber = getResponseTo("Find a book loan. Enter ISBN number:");
    	BookLoan bookLoan = bookLib.findLoan(isbnNumber);
    	if(bookLoan != null) { 
    		System.out.println(bookLoan);
    	}
    	else {
    		System.out.println("No book loan found with this isbn number.");
    	}  	
   	}
   	//list every bookloan
    //listBookLoans():void
    public void listBookLoans(){
    	for (int i = 0; i<bookLib.getLoanReg().size(); i++) {  
    		 System.out.println("Loan #"+(i+1));
          	 System.out.println(bookLib.getLoanReg().get(i));               //print every bookloan element
          	 System.out.println(" ");
          	}
   		
   	}
    //delete a user by first and last name
    //deleteUser(): void
    public void deleteUser() {
    	String firstName = getResponseTo("Please enter firstname to delete user");
    	String lastName = getResponseTo("Please enter lastname to delete user");
    	if(bookLib.deleteUser(firstName,lastName)) {
    		bookLib.getUserReg().remove(bookLib.findUser(firstName,lastName));
    		System.out.println("The user has been deleted");
    	}
    	else {
    		System.out.println("The user does not exist or there is an existing BookLoan with that user");
    	}
    }
    //delete a book by isbn number
    //deleteBook(): void
    public void deleteBook() {
    	String insnNumber = getResponseTo("Please enter isbnNumber to delete book");
    	if(bookLib.deleteBook(insnNumber)) {
    		bookLib.getBookReg().remove(bookLib.findBook(insnNumber));
    		System.out.println("The book has been deleted");
    	}
    	else {
    		System.out.println("The book does not exist or there is an existing BookLoan with that Book");
    	}
    	
    }
    //delete a bookloan by isbn number
    //deleteBookLoan(): void
    public void deleteBookLoan() {
    	String insnNumber = getResponseTo("Please enter isbnNumber to delete bookloan");
    	if(bookLib.deleteLoan(insnNumber)) {
    		bookLib.getLoanReg().remove(bookLib.findLoan(insnNumber));
    		System.out.println("The bookloan has been deleted");
    	}
    	else {
    		System.out.println("The bookloan does not exist");
    	}
    	
    	
    }
    
    //return user's choice, to make code more clear
    //getResponseTo(s: String): String
    private static String getResponseTo(String s) {
        System.out.println(s);
    	return(input.nextLine());
    	}
    //make sure a integer is greater than zero
    //isValidNumber(a: int): Boolean
    private static boolean isValidNumber(int a) {
    	if(a > 0) {
    		return true;
    	}
    	else {
    		System.out.println("Age must be greater than zero! Please enter again!");
    		return false;
    	}    	   	
    }
    //validate the book publication date
    //checkDate(date: String): boolean
    private static boolean checkDate(String date) {
    	 if(date.matches("\\d{4}")){               
      		 return true; 		
      	    }
      	  else{
      		System.out.println("The Date is not valid!"); 
      		return false; 
      	      }     	
    }
    /***************************
     * Reference
     * Title: <Java String - See if a string contains only numbers and not letters>
     * Author: <Guillaume Polet> 
     * Availability: <https://stackoverflow.com/questions/10575624/java-string-see-if-a-string-contains-only-numbers-and-not-letters>
     * *************************/
	//verify if input isbnnumber is 10 digits number
	//verifyISBNNumber(s: String): boolean
    private boolean verifyISBNNumber(String s) {
    	    if(s.matches("\\d{10}")){
    	    	return true;  		
     	    }
     	    else {
     		
     		    return false;
     	      }   	     	 		
	}

    
   
    
}

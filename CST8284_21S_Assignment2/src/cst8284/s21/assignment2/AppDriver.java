package cst8284.s21.assignment2;
/**
 * This class displays the menu for user to interface with the application by using 
 * .executeMenuItem() method and provide a loop for user to keep choice.
 * @author Ning Qin
 * @since 2021-06-11
 */

import java.util.Scanner;
//
public class AppDriver {
	private static final int APP_EXIT = 0;
	private static final int APP_ADD_BOOK = 1;
	private static final int APP_MOD_BOOK = 2;
	private static final int APP_FIND_BOOK = 3;
	private static final int APP_LIST_BOOKS = 4;
	private static final int APP_ADD_USER = 5;
	private static final int APP_MOD_USER = 6;
	private static final int APP_FIND_USER = 7;
	private static final int APP_LIST_USERS = 8;
	private static final int APP_ADD_LOAN = 9;
	private static final int APP_MOD_LOAN = 10;
	private static final int APP_FIND_LOAN = 11;
	private static final int APP_LIST_LOANS = 12;
	private static final int APP_DEL_BOOK = 13;
	private static final int APP_DEL_USER = 14;
	private static final int APP_DEL_LOAN = 15;
	
	private static Scanner input = new Scanner(System.in);
	static LendingLibraryController appControl = new LendingLibraryController();
	
	/*This class make method displayAppMenu() and executeMenuItem() been called in a loop
	 * so user can constantly input choices.*/
	//startApp(): void
	public void startApp() {
		int controlNumber = displayAppMenu();
			 executeMenuItem(controlNumber);
		while(APP_EXIT != controlNumber) {
			controlNumber = displayAppMenu();
	    	 executeMenuItem(controlNumber);			
		} 
	}
	//display the menu and make user input the choice
	//displayAppMenu(): int
	private static int displayAppMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(APP_ADD_BOOK+". Enter a new book");
		System.out.println(APP_MOD_BOOK+". Modify the book details. Enter the book isbn number");
		System.out.println(APP_FIND_BOOK+". Find a book by isbn number");
		System.out.println(APP_LIST_BOOKS+". Display list of all books");
		System.out.println(" ");
		System.out.println(APP_ADD_USER+". Add a new user");
		System.out.println(APP_MOD_USER+". Modify user details");
		System.out.println(APP_FIND_USER+". Find a user by name");
		System.out.println(APP_LIST_USERS+". Display all users");
		System.out.println(" ");
		System.out.println(APP_ADD_LOAN+". Add a loan. Link a user name to a book by isbn number");
		System.out.println(APP_MOD_LOAN+". Modify a loan. Loan is identified by isbn number");
		System.out.println(APP_FIND_LOAN+". Find a loan. Loan is identified by isbn number");
		System.out.println(APP_LIST_LOANS+". Display all loans");	
		System.out.println(" ");
		System.out.println(APP_DEL_BOOK+". Delete a book");
		System.out.println(APP_DEL_USER+". Delete a user");
		System.out.println(APP_DEL_LOAN+". Delete a loan");
		System.out.println(" ");
		System.out.println(APP_EXIT+". Exit program");	
		return input.nextInt();
		
	}
	/*executing user's choice and call the corresponding method in 
	 * the LendingLibraryController() class by object appControl*/
	//executeMenuItem(choice: int): void
	private static void executeMenuItem(int choice) {
		
		switch(choice) {
		
		case APP_ADD_BOOK:
			appControl.addBook();
			 break;
		
		case APP_MOD_BOOK:
			appControl.changeBook();
			 break;
		
		case APP_FIND_BOOK:
			appControl.findBook();
			 break;
				
		case APP_LIST_BOOKS:
			appControl.listBooks();
			 break;
		
		case APP_ADD_USER:
			appControl.addUser();
			 break;
		
		case APP_MOD_USER:
			appControl.changeUser();
			 break;
			
		case APP_FIND_USER:
			appControl.findUser();
			 break;
			
		case APP_LIST_USERS:
			appControl.listUsers();
			 break;
			
		case APP_ADD_LOAN:
			appControl.addBookLoan();
			 break;
			
		case APP_MOD_LOAN:
			appControl.changeBookLoan();
			 break;
			
		case APP_FIND_LOAN:
			appControl.findBookLoan();
			 break;
			
		case APP_LIST_LOANS:
			appControl.listBookLoans();
			 break;
			 
		case APP_DEL_BOOK:
			appControl.deleteBook();
			 break;
			
		case APP_DEL_USER:
			appControl.deleteUser();
			 break;
			
		case APP_DEL_LOAN:
			appControl.deleteBookLoan();
			 break;
			
		case APP_EXIT:
			 System.out.println("Good bye!");
			 break;
		default:
       	 System.out.println("Choice is not existing! Enter again!");
       	 break;
		
		}
		
		
	}
	
	

}

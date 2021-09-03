package cst8284.s21.assignment2;
/**
 * This class contains the main method which is an entry of the application.
 * @author Ning Qin
 * @since 2021-06-11
 *Class Name: Object Oriented Programming
 *Author Name: Ning Qin
 *Assignment Name: Java Assignment 2
 *Section Number: CST8284_302
 *Date: 18 July 2021
 */
public class AppLauncher {
    
	/* The main method can be used for instantiating an AppDriver object 
     * and use the object to call method startApp() in the AppDriver class.*/
	/* main(args: String[]): void */
	public static void main(String[] args) {
		AppDriver visitor = new AppDriver();
		visitor.startApp();

	}

}

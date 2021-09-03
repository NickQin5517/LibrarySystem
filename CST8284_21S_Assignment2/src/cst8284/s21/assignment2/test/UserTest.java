package cst8284.s21.assignment2.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst8284.s21.assignment2.Book;
import cst8284.s21.assignment2.User;

public class UserTest {
	private static final String DEFAULT_FIRSTNAME = "Willis";
	private static final String DEFAULT_LASTNAME = "Robert";
	private static final String DEFAULT_ADDRESS = "345 Woodroffe Avenue, Ottawa";
	private static final int DEFAULT_AGE = 21;
	User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 user = new User(DEFAULT_FIRSTNAME,DEFAULT_LASTNAME,DEFAULT_ADDRESS,DEFAULT_AGE);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUserIntStringStringStringInt_True() {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertTrue(firstName.equals(DEFAULT_FIRSTNAME)&&lastName.equals(DEFAULT_LASTNAME));
		
	}
	
	@Test
	public void testUserIntStringStringStringInt_False() {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertFalse(firstName.equals("")&&lastName.equals(""));
		
	}

	@Test
	public void testUserStringStringStringInt_True() {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertTrue(firstName.equals(DEFAULT_FIRSTNAME)&&lastName.equals(lastName));
	}

	@Test
	public void testUserStringStringStringInt_False() {

		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertFalse(firstName.equals("")&&lastName.equals(""));
		
	}
	
	@Test
	public void testUserStringStringString_True() {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertTrue(firstName.equals(DEFAULT_FIRSTNAME)&&lastName.equals(lastName));
	}
	
	@Test
	public void testUserStringStringString_False() {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		assertFalse(firstName.equals("")&&lastName.equals(""));				
	}

	@Test
	public void testGetFirstName_True() {
		String firstName = user.getFirstName();
		assertTrue(firstName.equals(DEFAULT_FIRSTNAME));
	}

	@Test
	public void testGetFirstName_False() {
		String firstName = user.getFirstName();
		assertFalse(firstName.equals(" "));
	}
	
	@Test
	public void testSetFirstName_True() {
		user.setFirstName(" ");
		String firstName = user.getFirstName();
		assertTrue(firstName.equals(" "));
	}
	
	@Test
	public void testSetFirstName_False() {
		user.setFirstName(DEFAULT_FIRSTNAME);
		String firstName = user.getFirstName();
		assertFalse(firstName.equals(" "));
	}
	
	@Test
	public void testGetLastName_True() {
		String lastName = user.getLastName();
		assertTrue(lastName.equals(DEFAULT_LASTNAME));
	}

	@Test
	public void testGetLastName_False() {
		String lastName = user.getFirstName();
		assertFalse(lastName.equals(" "));
	}
	
	@Test
	public void testSetLastName_True() {
		user.setLastName(" ");
		String lastName = user.getLastName();
		assertTrue(lastName.equals(" "));
	}

	@Test
	public void testSetLastName_False() {
		user.setLastName(DEFAULT_LASTNAME);
		String lastName = user.getFirstName();
		assertFalse(lastName.equals(" "));
	}
	
	@Test
	public void testGetAddress_True() {
		String address = user.getAddress();
		assertTrue(address.equals(DEFAULT_ADDRESS));
	}

	@Test
	public void testGetAddress_False() {
		String address = user.getAddress();
		assertFalse(address.equals(" "));
	}

	@Test
	public void testSetAddress_True() {
		user.setAddress(" ");
		String address = user.getAddress();
		assertTrue(address.equals(" "));
	}

	@Test
	public void testSetAddress_False() {
		user.setAddress(DEFAULT_ADDRESS);
		String address = user.getAddress();
		assertFalse(address.equals(" "));
	}

	@Test
	public void testGetAge_True() {
		int age = user.getAge();
		assertTrue(age == DEFAULT_AGE);
	}
	
	@Test
	public void testGetAge_False() {
		int age = user.getAge();
		assertFalse(age == 5);
	}

	@Test
	public void testSetAge_True() {
		user.setAge(5);
		int age = user.getAge();
		assertTrue(age == 5);
	}

	@Test
	public void testSetAge_False() {
		user.setAge(DEFAULT_AGE);
		int age = user.getAge();
		assertFalse(age == 5);
	}
	
	@Test
	public void testGetUser_True() {
		User secondUser = user.getUser();
		assertTrue(user.equals(secondUser));
	}
	
	@Test
	public void testGetUser_False() {
		User secondUser = new User("Singh","Raja","45 Woodfield avenue, Ottawa",23);
		assertFalse(user.equals(secondUser));
	}

	@Test
	public void testToString_True() {
		String str = user.toString();
		assertTrue(str.contains(DEFAULT_FIRSTNAME)&&str.contains(DEFAULT_LASTNAME));
	}
	
	@Test
	public void testToString_False() {
		User secondUser = new User("Singh","Raja","45 Woodfield avenue, Ottawa",23);
		String str = user.toString();
		String str2 = secondUser.toString();
		assertFalse(str.equals(str2));
	}

	@Test
	public void testEqualsObject_True() {
		User secondUser = new User(DEFAULT_FIRSTNAME,DEFAULT_LASTNAME,DEFAULT_ADDRESS,DEFAULT_AGE);
		assertTrue(user.equals(secondUser));
	}
	
	@Test
	public void testEqualsObject_False() {
		User secondUser = new User("Singh","Raja","45 Woodfield avenue, Ottawa",23);
		assertFalse(user.equals(secondUser));
	}

}

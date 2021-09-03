package cst8284.s21.assignment2;
/**
 * This class can used for creating User object through constructor,
 *  getters and setters,then return User type.
 * @author Ning Qin
 * @since 2021-06-11
 *Class Name: Object Oriented Programming
 *Author Name: Ning Qin
 *Assignment Name: Java Assignment 2
 *Section Number: CST8284_302
 *Date: 18 July 2021
 */

public class User {
	
	private static int userNextId = 1000;
	private  int id;
	private  String firstName;
	private  String lastName;
	private  String address;
	private  int age;
	private static final int DEFAULT_AGE = 18;
	
	//User constructor that take in int, String, String, String, int from below constructor as parameters.
	//User(id:int, firstName:String, lastName:String, address:String, age:int)
	public User(int id, String firstName,String lastName,String address,int age) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setAge(age);
	}
	//User constructor that take in String, String, String, int from below constructor as parameters.
    //User(firstName:String, lastName:String, address:String, age:int)
	public User(String firstName,String lastName,String address,int age) {
		this(0,firstName,lastName,address,age);
	}
	//User constructor that take in String, String, String as parameters.
    //User(firstName:String, lastName:String, address:String)
	public User(String firstName,String lastName,String address) {
		this(firstName,lastName,address,DEFAULT_AGE);
	}	
	//getter for id
	//getId():int
	public int getId() {
		return id;
	}
	//setter for id
	//setId(id:int):void
	public void setId(int id) {
		id = userNextId++;
		this.id = id;
	}
	//getter for firstName
	//getFirstName():String
	public String getFirstName() {
		return firstName;
	}
	//setter for firstName
	//setFirstName(firstName:String):void
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//getter for lastName
	//getLastName():String
	public String getLastName() {
		return lastName;
	}
	//setter for lastName
	//setLastName(lastName:String):void
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	//getter for address
	//getAddress():String
	public String getAddress() {
		return address;
	}
	//setter for address
	//setAddress(address:String):void
	public void setAddress(String address) {
		this.address = address;
	}
	//getter for age
	//getAge():int	
	public int getAge() {
		return age;
	}
	//setter for age
	//setAge(age:int):void	
	public void setAge(int age) {
		this.age = age;
	}
	//getter for User
	//getUser():User		
	public User getUser() {
		return this;
	}
	//return User object as a String type
	//toString():String
	@Override
	public String toString() {		
		return "************User id: " + getId()+"\r\n"+
				"************User name: " + getFirstName()+" "+getLastName()+"\r\n"+
				"************User Age: " + getAge()+"\r\n"+
				"************User Address: " + getAddress();
	}
	//equals(obj:Object):boolean
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof User && obj != null) {
			User cmpObj = (User) obj;
			return (this.getFirstName().equals(cmpObj.getFirstName()) && this.getLastName().equals(cmpObj.getLastName())
					&&this.getAge()==cmpObj.getAge()&&this.getAddress().equals(cmpObj.getAddress()))? true : false;
		}
		else {
			return false;
		}
		
	}

}

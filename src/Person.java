

import java.util.*;

public class Person {
	private String name;
	private int age;
	private String address;
	
	public Person(){
		name = "none";
		age = 0;
	}
	
	public Person(String n){
		name = n;
		age = 0;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String value) {
		name = value;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public int getAge(){
		return age;
	}
}
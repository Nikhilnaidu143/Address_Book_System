package com.Address_book_system;

public class Contact_info {
	String First_Name;
	String Last_Name;
	String Address;
	String City;
	String State;
	int Zip_code;
	int Phone_number;
	String Email;
	
	public Contact_info(String fn, String ln, String add, String city, String state, int zip, int ph, String email) {
		
		this.First_Name = fn;
		this.Last_Name = ln;
		this.Address = add;
		this.City = city;
		this.State = state;
		this.Zip_code = zip;
		this.Phone_number = ph;
		this.Email = email;
	}
	
	public String toString() {
		return String.format(First_Name + " " + Last_Name + " " + Address + " " + City + " " + State + " " + Zip_code + " " + Phone_number + " " + Email);
	}
	
	
}

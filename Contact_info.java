package com.Address_book_system;

public class Contact_info {
	String First_Name;
	String Last_Name;
	String Address;
	String City;
	String State;
	int Zip_code;
	long Phone_number;
	String Email;
	
	public Contact_info(String first_name , String last_name, String address , String city, String state, int zip_code , long phone_number, String email) {
		
		this.First_Name = first_name;
		this.Last_Name = last_name;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Zip_code = zip_code;
		this.Phone_number = phone_number;
		this.Email = email;
	}
	

	public String getFirst_Name() {
		return First_Name;
	}


	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}


	public String getLast_Name() {
		return Last_Name;
	}


	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getCity() {
		return City;
	}


	public void setCity(String city) {
		City = city;
	}


	public String getState() {
		return State;
	}


	public void setState(String state) {
		State = state;
	}


	public int getZip_code() {
		return Zip_code;
	}


	public void setZip_code(int zip_code) {
		Zip_code = zip_code;
	}


	public long getPhone_number() {
		return Phone_number;
	}


	public void setPhone_number(long phone_number) {
		Phone_number = phone_number;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	@Override
	public String toString() {
		return String.format(getFirst_Name() + " " + getLast_Name() + " " + getAddress() + " " + getCity() + " " + getState() + " " + getZip_code() + " " + getPhone_number() + " " + getEmail());
	}
	
	
}

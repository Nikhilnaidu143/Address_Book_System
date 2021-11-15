package com.Address_book_system;

public class AddressBookList {
	
	String userInputBookName;

	// constructor
	public AddressBookList(String userInputBookName) {
		this.userInputBookName = userInputBookName;
	}


	public String getUserInputBookName() {
		return userInputBookName;
	}


	public void setUserInputBookName(String userInputBookName) {
		this.userInputBookName = userInputBookName;
	}
	
	
	public String toString() {
		return "Address Book name :- " + userInputBookName + "\n";
	}
	
	
}

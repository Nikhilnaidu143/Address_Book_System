package com.addressbooksystem.entity;

import java.util.ArrayList;

public class AddressBook {
	//instance variable.
	public String userInputBookName;
	public ArrayList<Contact> contact;
	
	// parameterized constructor
	public AddressBook(String userInputBookName) {
		this.userInputBookName = userInputBookName;
		this.contact = new ArrayList<Contact>();
	}

	// getters and methods.
	public String getUserInputBookName() {
		return userInputBookName;
	}

	public void setUserInputBookName(String userInputBookName) {
		this.userInputBookName = userInputBookName;
	}
	
	public ArrayList<Contact> getContact() {
		return contact;
	}

	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
	}

	/*** Overriding toString() method ***/
	@Override
	public String toString() {
		return "Address Book name :- " + userInputBookName + "\n" + "Contacts :- " + contact;
	}
}
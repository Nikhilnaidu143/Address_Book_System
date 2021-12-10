package com.addressbooksystem;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class AddressBook {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Contact_info> contactBook = new ArrayList<>(); // creating array list of class Contact_info
	static ArrayList<AddressBookList> addressBookNameList = new ArrayList<>();

	// building add contact feature
	public void addContact() {

		System.out.print("\nEnter First Name:- ");
		String first = input.next();

		System.out.print("Enter Last Name:- ");
		String last = input.next();

		System.out.print("Enter Address:- ");
		String add = input.next();

		System.out.print("Enter City:- ");
		String city = input.next();

		System.out.print("Enter State:- ");
		String state = input.next();

		System.out.print("Enter Zip Code:- ");
		int zip = input.nextInt();

		System.out.print("Enter Phone Number:- ");
		long phone = input.nextLong();

		System.out.print("Enter E-mail:- ");
		String email = input.next();

		Contact_info contact = new Contact_info(first, last, add, city, state, zip, phone, email);
		if (duplicateCheck(first)) {
			contactBook.add(contact);
			System.out.println("\nContact added Successfully.\n");
		} else {
			System.out.println("\nYou have already this person in your contact list.\n");
		}
	}

	// displaying all existing contacts
	public void displayContacts() {
		System.out.println("\n---------------Contacts in Address Book----------------");
		for (Contact_info person : contactBook) {
			System.out.println(person.toString());
		}
	}

	// Building edit contact feature
	public void editContact() {
		System.out.println("\nEnter first name to edit :- ");
		String name = input.next();

		for (Contact_info person : contactBook) {
			if (name.equals(person.first_Name)) {
				System.out.print("\nSelect option to edit..." + " 1.First_name." + " 2.Last_name." + " 3.Address."
						+ " 4.City" + " 5.State" + " 6.Zip_code" + " 7.Phone_number" + " 8.Email :- ");
				int option = input.nextInt();
				switch (option) {
				case 1:
					System.out.print("Enter new first name :- ");
					String newFirstName = input.next();
					person.setFirst_Name(newFirstName);
					System.out.println("First name is updated.");
					break;

				case 2:
					System.out.print("Enter new last name :- ");
					String newLastName = input.next();
					person.setLast_Name(newLastName);
					System.out.println("Last name is updated.");
					break;

				case 3:
					System.out.print("Enter new Address :- ");
					String newAddress = input.next();
					person.setAddress(newAddress);
					System.out.println("Address is updated.");
					break;

				case 4:
					System.out.print("Enter new city name :- ");
					String newCity = input.next();
					person.setCity(newCity);
					System.out.println("City is updated.");
					break;

				case 5:
					System.out.print("Enter new state name :- ");
					String newState = input.next();
					person.setState(newState);
					System.out.println("State is updated.");
					break;

				case 6:
					System.out.print("Enter new Zip code :- ");
					int newZip = input.nextInt();
					person.setZip_code(newZip);
					System.out.println("Zip code is updated.");
					break;

				case 7:
					System.out.print("Enter new phonr number :- ");
					long newPhone = input.nextLong();
					person.setPhone_number(newPhone);
					System.out.println("Phone number is updated.");
					break;

				case 8:
					System.out.print("Enter new email :- ");
					String newEmail = input.next();
					person.setEmail(newEmail);
					System.out.println("Email is updated.");
					break;

				default:
					System.out.println("Please enter a number between 1 to 8 only...");

				}
			} else {
				continue;
			}
		}
	}

	// adding deleting contact by name feature
	public void deleteContact() {
		System.out.print("Enter first name to delete contact:- ");
		String deleteByName = input.next();

		for (int i = 0; i < contactBook.size(); i++) {
			String Finding_name_in_arrayList = contactBook.get(i).getFirst_Name();

			if (deleteByName.equals(Finding_name_in_arrayList)) {
				contactBook.remove(i);
				System.out.println("\nSelected contact deleted successfully.\n");
				break;
			} else {
				continue;
			}
		}
	}

	// UC-5:- adding multiple person details feature added.
	public void addMultiplePersons() {
		System.out.println("Enter how many contacts you want to add :- ");
		int userWant = input.nextInt();
		for (int i = 1; i <= userWant; i++) {
			addContact();
		}
	}

	// UC-6:- Ability to add multiple address books to system
	public void newAddressBook() {
		System.out.println("Enter Address Book Name :- ");
		String userInputBookName = input.next();

		AddressBookList addressBookObj = new AddressBookList(userInputBookName);
		addressBookNameList.add(addressBookObj);

		System.out.println("New Address Book Name is added to list.");
	}

	// display address book
	public void displayAddressBook() {
		for (AddressBookList addressBookName : addressBookNameList) {
			System.out.println(addressBookName.toString());
		}
	}

	/**
	 * UC-7:- Ability to ensure there is no Duplicate Entry of the same Person in a
	 * particular Address Book.
	 **/
	public boolean duplicateCheck(String first) {
		for (int i = 0; i < contactBook.size(); i++) {
			String getFirstName = contactBook.get(i).first_Name;
			if (getFirstName.equalsIgnoreCase(first)) {
				return false;
			} else {
				continue;
			}
		}
		return true;
	}

	/**
	 * UC-9:- Ability to view Persons by City or State - Maintain Dictionary of City
	 * and Person as well as State and Person
	 **/
	public void searchPersonByCity() {
		System.out.print("\nEnter city to search person by city name :- ");
		String searchCity = input.next();
		
		/***** Creating dictionary of city(keys) and name(values) *****/
		Dictionary cityWiseDict = new Hashtable();
		contactBook.stream().filter(hashTable -> hashTable.getCity().contains(searchCity)).forEach(contactBook -> cityWiseDict.put(contactBook.getFirst_Name(), searchCity));
		
		System.out.println("Persons who are in same city " + searchCity + " :- ");
		for(Enumeration i = cityWiseDict.keys(); i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}

	public void searchPersonByState() {
		System.out.print("\nEnter State to search person by State name :- ");
		String searchState = input.next();
		
		/***** Creating dictionary of state(keys) and name(values) *****/
		Dictionary stateWiseDict = new Hashtable();
		contactBook.stream().filter(hashTable -> hashTable.getCity().contains(searchState)).forEach(contactBook -> stateWiseDict.put(contactBook.getFirst_Name(), searchState));
		
		System.out.println("Persons who are in same State " + searchState + " :- ");
		for(Enumeration i = stateWiseDict.keys(); i.hasMoreElements();) {
			System.out.println(i.nextElement());
		}
		System.out.println(" ");
	}

	// main method
	public static void main(String[] args) {
		System.out.println("--------------------Welcome To Address Book Program-----------------------");
		AddressBook obj = new AddressBook();

		System.out.print("Enter valid option to perform Address Book Application[1.Enter (or) 2.Exit] :- ");
		int enterExit = input.nextInt();
		if (enterExit == 1) {
			while (enterExit != 2) {
				System.out.println("Choose which operation you want to perform from below list :- ");
				System.out.println("1.Add Contact.");
				System.out.println("2.Edit Contact");
				System.out.println("3.Delete Contact");
				System.out.println("4.Display Contact.");
				System.out.println("5.Add new address book.");
				System.out.println("6.Display Address Book");
				System.out.println("7.Search Person By City Name.");
				System.out.println("8.Search Person By State Name.");
				System.out.println("9.Exit from the Application");

				System.out.println("\nEnter your choice :- ");
				int userChoice = input.nextInt();

				switch (userChoice) {
				case 1:
					obj.addMultiplePersons();
					break;
				case 2:
					obj.editContact();
					break;
				case 3:
					obj.deleteContact();
					break;
				case 4:
					obj.displayContacts();
					break;
				case 5:
					obj.newAddressBook();
					break;
				case 6:
					obj.displayAddressBook();
					break;
				case 7:
					obj.searchPersonByCity();
					break;
				case 8:
					obj.searchPersonByState();
					break;
				default:
					System.out.println("Enter valid choice from the list...");
				}
				if (userChoice == 9) {
					System.out.println("Successfully exited from the Address Book Application.");
					break;
				}
			}
		} else if (enterExit == 2) {
			System.out.println("Successfully exited from the Address Book Application.");
		} else {
			System.out.println("Choose Valid option [1.Enter (or) 2.Exit]...");
		}
	}
}
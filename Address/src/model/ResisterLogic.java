package model;

import java.util.List;

import dao.AddressBookDAO;

public class ResisterLogic {
	public boolean execute(AddressBook addressBook) {
		AddressBookDAO dao = new AddressBookDAO();
		return dao.resisterAddressBook(addressBook);
	}
}

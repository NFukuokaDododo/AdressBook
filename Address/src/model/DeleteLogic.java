package model;

import dao.AddressBookDAO;

public class DeleteLogic {
	public boolean execute(String id) {
		AddressBookDAO dao = new AddressBookDAO();
		return dao.deleteAddressBook(id);
	}
}

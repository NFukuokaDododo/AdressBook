package model;

import dao.AddressBookUserDAO;

public class LoginLogic {
	AddressBookUserDAO addressBookUserDAO = new AddressBookUserDAO();
	public boolean execute(Login login) {
		AddressBookUser addressBookUser = addressBookUserDAO.findAddressBookUser(login);
		return addressBookUser != null;
	}
}

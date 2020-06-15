package model;

import dao.AddressBookDAO;

public class UpdateLogic {
	public boolean execute(AddressBook addressBook) {
		AddressBookDAO dao = new AddressBookDAO();
		return dao.UpdateAddressBook(addressBook);
		//エラーチェック
	}
}

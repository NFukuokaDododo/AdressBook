package model;

import java.util.List;

import dao.AddressBookDAO;

public class GetAddressBookListLogic {
	
	//一覧用
	public List<AddressBook> execute(int pages) {
		AddressBookDAO dao = new AddressBookDAO();
		List<AddressBook> addressBookList = dao.findAddressBook(pages);
		return addressBookList;
	}
	
	//検索用
	public List<AddressBook> execute(String name, String address) {
		AddressBookDAO dao = new AddressBookDAO();
		List<AddressBook> addressBookList = dao.findSearchedAddressBook(name, address);
		return addressBookList;
	}
	
	//名前のみの検索
	public List<AddressBook> executeName(String name) {
		AddressBookDAO dao = new AddressBookDAO();
		List<AddressBook> addressBookList = dao.findNameSearchedAddressBook(name);
		return addressBookList;
	}
	
	//住所のみの検索
	public List<AddressBook> executeAddress(String address) {
		AddressBookDAO dao = new AddressBookDAO();
		List<AddressBook> addressBookList = dao.findAddressSearchedAddressBook(address);
		return addressBookList;
	}
	
	//レコードの数を返す
	public int executeCount() {
		AddressBookDAO dao = new AddressBookDAO();
		int count = dao.count();
		return count;
	}
}

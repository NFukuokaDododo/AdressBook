package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddressBookBackup implements Serializable {
	
	private String  id;
	private String name;
	private int gender;
	private Long phonenumber;
	private String emailaddress;
	private int postalcode;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private Date birth;
	private int age;
	private String birthplace;
	
	public AddressBookBackup() {}

	public AddressBookBackup(String id, String name, int gender, Long phonenumber, String emailaddress, int postalcode,
			String address1, String address2, String address3, String address4, String address5, Date birth, int age,
			String birthplace) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.emailaddress = emailaddress;
		this.postalcode = postalcode;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.address5 = address5;
		this.birth = birth;
		this.age = age;
		this.birthplace = birthplace;
	}

	public AddressBookBackup(InputAddressBook inputAddressBook) {
		createAddressBook(inputAddressBook);
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getGender() {
		return gender;
	}

	public Long getPhonenumber() {
		return phonenumber;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public int getPostalcode() {
		return postalcode;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getAddress3() {
		return address3;
	}

	public String getAddress4() {
		return address4;
	}

	public String getAddress5() {
		return address5;
	}

	public Date getBirth() {
		return birth;
	}

	public int getAge() {
		return age;
	}

	public String getBirthplace() {
		return birthplace;
	}
	
	public void createAddressBook(InputAddressBook inputAddressBook) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		this.id = inputAddressBook.getId();
		this.name = inputAddressBook.getName();
		this.gender = Integer.parseInt(inputAddressBook.getGender());
		this.phonenumber = Long.parseLong(inputAddressBook.getPhonenumber());
		this.emailaddress = inputAddressBook.getEmailaddress();
		this.postalcode = Integer.parseInt(inputAddressBook.getPostalcode());
		this.address1 = inputAddressBook.getAddress1();
		this.address2 = inputAddressBook.getAddress2();
		this.address3 = inputAddressBook.getAddress3();
		this.address4 = inputAddressBook.getAddress4();
		this.address5 = inputAddressBook.getAddress5();
		this.birth = new Date();
		try {
			 birth = sdFormat.parse(inputAddressBook.getBirth());
		}catch(ParseException e) {
			e.printStackTrace();
		}
		this.birthplace = inputAddressBook.getBirthplace();
	}
	
}

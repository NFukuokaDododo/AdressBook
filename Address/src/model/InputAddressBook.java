package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputAddressBook implements Serializable {
	private String id;
	private String name;
	private String gender;
	private String phonenumber;
	private String emailaddress;
	private String postalcode;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String birth;
	private String age;
	private String birthplace;
	
	public InputAddressBook(String id, String name, String gender, String phonenumber, String emailaddress,
			String postalcode, String address1, String address2, String address3, String address4, String address5,
			String birth, String age, String birthplace) {
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

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public String getPostalcode() {
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

	public String getBirth() {
		return birth;
	}

	public String getAge() {
		return age;
	}

	public String getBirthplace() {
		return birthplace;
	}
	
	public String errorCheck() {
		if(!nameCheck()){
			return "名前が正しくありません";
		}else if(!genderCheck()) {
			return "性別が正しくありません";
		}else if(!phonenumberCheck()) {
			return "電話番号が正しくありません";
		}else if(!emailaddressCheck()) {
			return "メールアドレスが正しくありません";
		}else if(!postalcodeCheck()) {
			return "郵便番号が正しくありません";
		}else if(!address1Check()) {
			return "住所1が正しくありません";
		}else if(!address2Check()) {
			return "住所2が正しくありません";
		}else if(!address3Check()) {
			return "住所3が正しくありません";
		}else if(!address4Check()) {
			return "住所4が正しくありません";
		}else if(!address5Check()) {
			return "住所5が正しくありません";
		}else if(!birthCheck()) {
			return "生年月日が正しくありません";
		}else if(!birthplaceCheck()) {
			return "出身地が正しくありません";
		}else {
			return "";
		}
	}
	public boolean nameCheck() {
		if(name.length() > 0 && name.length() <= 20) {
			return true;
		}else {
			return false;
		}
	}
	public boolean genderCheck() {
		if(gender.equals("1") || gender.equals("2")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean phonenumberCheck() {
		if(phonenumber.toString().matches("[0-9]{10,11}")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean emailaddressCheck() {
		if(emailaddress.matches("^(?=.*@).*") && emailaddress.length() <= 50) {
			return true;
		}else {
			return false;
		}
	}
	public boolean postalcodeCheck() {
		if(postalcode.matches("[0-9]{7}")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean address1Check() {
		if(address1.matches("^(?!.*\\w).*") && address1.length() <= 5) {
			return true;
		}else {
			return false;
		}
	}
	public boolean address2Check() {
		if(address2.matches("^(?!.*\\w).*") && address2.length() <= 20) {
			return true;
		}else {
			return false;
		}
	}
	public boolean address3Check() {
		if(address3.matches("^(?!.*\\w).*") && address3.length() <= 20) {
			return true;
		}else {
			return false;
		}
	}
	public boolean address4Check() {
		if(address4.length() <= 20) {
			return true;
		}else {
			return false;
		}
	}
	public boolean address5Check() {
		if(address5.length() <= 30) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean birthCheck() {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd");
		sdFormat.setLenient(false);
		try{
			Date parseDate = sdFormat.parse(birth);
			return true;
		}catch(ParseException e) {
			return false;
		}
	}
	public boolean ageCheck() {
		if(age.matches("^[1-9]+[0-9]*$") || age.equals("0")) {
			return true;
		}else {
			return false;
		}
	}
	public boolean birthplaceCheck() {
		if(birthplace.length() <= 5) {
			return true;
		}else {
			return false;
		}
	}
}
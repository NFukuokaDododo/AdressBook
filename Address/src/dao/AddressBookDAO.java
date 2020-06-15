package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.AddressBook;

public class AddressBookDAO {
	public List<AddressBook> findAllAddressBook() {
		Connection conn = null;
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//SELECT文を準備
			String sql = "SELECT * FROM addressbook ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String name = rs.getString("name");
				int gender = rs.getInt("gender");
				Long phonenumber = rs.getLong("phonenumber");
				String emailaddress = rs.getString("emailaddress");
				int postalcode = rs.getInt("postalcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				String address5 = rs.getString("address5");
				Date birth = rs.getDate("birth");
				int age = rs.getInt("age");
				String birthplace = rs.getString("birthplace");
				
				AddressBook addressBook = new AddressBook(id, name, gender, phonenumber, emailaddress, postalcode, address1, address2, address3, address4, address5, birth, age, birthplace);
				addressBookList.add(addressBook);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return addressBookList;
	}
	
	//10件のみ取得
	public List<AddressBook> findAddressBook(int pages) {
		Connection conn = null;
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//SELECT文を準備
			String sql = "SELECT * FROM addressbook ORDER BY id LIMIT 10 OFFSET ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			pStmt.setInt(1, (pages - 1) * 10);
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String name = rs.getString("name");
				int gender = rs.getInt("gender");
				Long phonenumber = rs.getLong("phonenumber");
				String emailaddress = rs.getString("emailaddress");
				int postalcode = rs.getInt("postalcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				String address5 = rs.getString("address5");
				Date birth = rs.getDate("birth");
				int age = rs.getInt("age");
				String birthplace = rs.getString("birthplace");
				
				AddressBook addressBook = new AddressBook(id, name, gender, phonenumber, emailaddress, postalcode, address1, address2, address3, address4, address5, birth, age, birthplace);
				addressBookList.add(addressBook);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return addressBookList;
	}
	public List<AddressBook> findSearchedAddressBook(String name, String address) {
		Connection conn = null;
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//SELECT文を準備
			String sql = "SELECT * FROM addressbook WHERE name LIKE ? AND ( address1 LIKE ? OR address2 LIKE ? OR address3 LIKE ? OR address4 LIKE ? OR address5 LIKE ? ) ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + name + "%");
			pStmt.setString(2, "%" + address + "%");
			pStmt.setString(3, "%" + address + "%");
			pStmt.setString(4, "%" + address + "%");
			pStmt.setString(5, "%" + address + "%");
			pStmt.setString(6, "%" + address + "%");
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String searchedName = rs.getString("name");
				int gender = rs.getInt("gender");
				Long phonenumber = rs.getLong("phonenumber");
				String emailaddress = rs.getString("emailaddress");
				int postalcode = rs.getInt("postalcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				String address5 = rs.getString("address5");
				Date birth = rs.getDate("birth");
				int age = rs.getInt("age");
				String birthplace = rs.getString("birthplace");
			
				AddressBook addressBook = new AddressBook(id, searchedName, gender, phonenumber, emailaddress, postalcode, address1, address2, address3, address4, address5, birth, age, birthplace);
				addressBookList.add(addressBook);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return addressBookList;
	}
	//名前のみ検索
	public List<AddressBook> findNameSearchedAddressBook(String name) {
		Connection conn = null;
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//SELECT文を準備
			String sql = "SELECT * FROM addressbook WHERE name LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + name + "%");
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String searchedName = rs.getString("name");
				int gender = rs.getInt("gender");
				Long phonenumber = rs.getLong("phonenumber");
				String emailaddress = rs.getString("emailaddress");
				int postalcode = rs.getInt("postalcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				String address5 = rs.getString("address5");
				Date birth = rs.getDate("birth");
				int age = rs.getInt("age");
				String birthplace = rs.getString("birthplace");
			
				AddressBook addressBook = new AddressBook(id, searchedName, gender, phonenumber, emailaddress, postalcode, address1, address2, address3, address4, address5, birth, age, birthplace);
				addressBookList.add(addressBook);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return addressBookList;
	}
	
	//住所のみ検索
	public List<AddressBook> findAddressSearchedAddressBook(String address) {
		Connection conn = null;
		List<AddressBook> addressBookList = new ArrayList<AddressBook>();
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//SELECT文を準備
			String sql = "SELECT * FROM addressbook WHERE address1 LIKE ? OR address2 LIKE ? OR address3 LIKE ? OR address4 LIKE ? OR address5 LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + address + "%");
			pStmt.setString(2, "%" + address + "%");
			pStmt.setString(3, "%" + address + "%");
			pStmt.setString(4, "%" + address + "%");
			pStmt.setString(5, "%" + address + "%");
			
			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String  id = rs.getString("id");
				String searchedName = rs.getString("name");
				int gender = rs.getInt("gender");
				Long phonenumber = rs.getLong("phonenumber");
				String emailaddress = rs.getString("emailaddress");
				int postalcode = rs.getInt("postalcode");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String address3 = rs.getString("address3");
				String address4 = rs.getString("address4");
				String address5 = rs.getString("address5");
				Date birth = rs.getDate("birth");
				int age = rs.getInt("age");
				String birthplace = rs.getString("birthplace");
			
				AddressBook addressBook = new AddressBook(id, searchedName, gender, phonenumber, emailaddress, postalcode, address1, address2, address3, address4, address5, birth, age, birthplace);
				addressBookList.add(addressBook);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return addressBookList;
	}
	
	public boolean resisterAddressBook(AddressBook addressBook) {
		Connection conn = null;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//INSERT文を準備
			String sql = "";
			sql += "INSERT INTO addressbook (name,";
			sql += "gender,";
			sql += "phonenumber,";
			sql += "emailaddress,";
			sql += "postalcode,";
			sql += "address1,";
			sql += "address2,";
			sql += "address3,";
			sql += "address4,";
			sql += "address5,";
			sql += "birth,";
			sql += "age,";
			sql += "birthplace)";
			
			sql += "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, addressBook.getName());
			pStmt.setInt(2, addressBook.getGender());
			pStmt.setLong(3, addressBook.getPhonenumber());
			pStmt.setString(4, addressBook.getEmailaddress());
			pStmt.setInt(5, addressBook.getPostalcode());
			pStmt.setString(6, addressBook.getAddress1());
			pStmt.setString(7, addressBook.getAddress2());
			pStmt.setString(8, addressBook.getAddress3());
			pStmt.setString(9, addressBook.getAddress4());
			pStmt.setString(10, addressBook.getAddress5());
			java.sql.Date sDate = new java.sql.Date(addressBook.getBirth().getTime());
			pStmt.setDate(11, sDate);
			pStmt.setInt(12, addressBook.getAge());
			pStmt.setString(13, addressBook.getBirthplace());
			
			//INSERT文を実行
			int insertCount = pStmt.executeUpdate();
			
			if(insertCount != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
	
	public boolean deleteAddressBook(String id) {
		Connection conn = null;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//DELETE文を準備
			String sql = "DELETE FROM addressbook WHERE id = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int deleteId = Integer.parseInt(id);
			pStmt.setInt(1, deleteId);
			
			//DELETE文を実行
			int insertCount = pStmt.executeUpdate();
			
			if(insertCount != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
	
	public boolean UpdateAddressBook(AddressBook addressBook) {
		Connection conn = null;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//UPDATE文を準備
			String sql = "";
			sql += "UPDATE addressbook SET";
			sql += "(name,";
			sql += "gender,";
			sql += "phonenumber,";
			sql += "emailaddress,";
			sql += "postalcode,";
			sql += "address1,";
			sql += "address2,";
			sql += "address3,";
			sql += "address4,";
			sql += "address5,";
			sql += "birth,";
			sql += "age,";
			sql += "birthplace) =";
						
			sql += "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			sql += "WHERE id = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, addressBook.getName());
			pStmt.setInt(2, addressBook.getGender());
			pStmt.setLong(3, addressBook.getPhonenumber());
			pStmt.setString(4, addressBook.getEmailaddress());
			pStmt.setInt(5, addressBook.getPostalcode());
			pStmt.setString(6, addressBook.getAddress1());
			pStmt.setString(7, addressBook.getAddress2());
			pStmt.setString(8, addressBook.getAddress3());
			pStmt.setString(9, addressBook.getAddress4());
			pStmt.setString(10, addressBook.getAddress5());
			java.sql.Date sDate = new java.sql.Date(addressBook.getBirth().getTime());
			pStmt.setDate(11, sDate);
			pStmt.setInt(12, addressBook.getAge());
			pStmt.setString(13, addressBook.getBirthplace());
			pStmt.setInt(14, Integer.parseInt(addressBook.getId()));
			
			//UPDATE文を実行
			int UpdateCount = pStmt.executeUpdate();
			
			if(UpdateCount != 0) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}
	
	public int count() {
		Connection conn = null;
		int count = 0;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");
			
			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");
			
			//COUNT関数を準備
			String sql = "SELECT COUNT(*) AS count FROM addressbook";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SELECT文を実行
			ResultSet rs = pStmt.executeQuery();
			
			rs.next();
			count = rs.getInt("count");
			
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			return 0;
		}finally {
			//データベースを切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
		return count;
	}
}

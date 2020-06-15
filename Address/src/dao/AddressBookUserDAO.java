package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AddressBookUser;
import model.Login;

public class AddressBookUserDAO {
	public AddressBookUser findAddressBookUser(Login login) {
		Connection conn = null;
		AddressBookUser addressBookUser = null;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.postgresql.Driver");

			//データベースへ接続
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/addressbook", "postgres", "THacE3raf1L2");

			//SELECT文を準備
			String sql = "SELECT user_id,  password FROM addressbookuser WHERE user_id = ? AND password = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getId());
			pStmt.setString(2, login.getPassword());

			//SELECT文を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//一致したユーザーが存在した場合そのユーザーを表すAddressBookUserインスタンスを生成
			if(rs.next()) {
				//結果表からデータを取得
				String id = rs.getString("user_id");
				//String name = rs.getString("name");
				String password = rs.getString("password");

				addressBookUser = new AddressBookUser(id, password);
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
		//見つかったユーザーまたはnullを返す
		return addressBookUser;
	}
}

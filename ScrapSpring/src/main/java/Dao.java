package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bean;

public class Dao {

	public ArrayList<Bean> result() throws ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;

		ResultSet rs = null;

		ArrayList<Bean> result = new ArrayList<Bean>();

		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager
					.getConnection("jdbc:postgresql://localhost/sample",
							"postgres", "sqlpass");

			pst = con.prepareStatement("SELECT * FROM mb2");

			rs = pst.executeQuery();

			while (rs.next()) {

				String message = rs.getString("message");

				String name = rs.getString("name");

				String no = rs.getString("no");

				Bean bean = new Bean();

				bean.setMessage(message);

				bean.setName(name);

				bean.setNo(no);

				result.add(bean);

			}

		} catch (ClassNotFoundException e) {

			System.out.println("くらすのっとえくせぷしょん");
		} catch (SQLException e) {
			System.out.println("ＳＱＬえくせぷしょん");
		} finally {

		}
		return result;

	}

	public String[] getUser(String sNum) throws ClassNotFoundException,
			SQLException {

		Connection con = null;

		PreparedStatement pst = null;

		ResultSet rs = null;

		String[] userData = new String[2];

		int iNum = Integer.parseInt(sNum);

		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager
					.getConnection("jdbc:postgresql://localhost/sample",
							"postgres", "sqlpass");

			pst = con.prepareStatement("SELECT * FROM test where id = ?");

			pst.setInt(1, iNum);

			rs = pst.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");

				String id = rs.getString("id");

				userData[0] = name;

				userData[1] = id;

			}

		} catch (ClassNotFoundException e) {

			System.out.println("くらすのっとえくせぷしょん");
		} catch (SQLException e) {
			System.out.println("ＳＱＬえくせぷしょん");
		} finally {

		}
		return userData;

	}

	public void inputDB(String name, String sNum) throws ClassNotFoundException, SQLException {

		Connection con = null;

		PreparedStatement pst = null;



		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager
					.getConnection("jdbc:postgresql://localhost/sample",
							"postgres", "sqlpass");

			pst = con.prepareStatement("insert into mb2 (message, name) values (?, ?)");

			pst.setString(1, sNum);

			pst.setString(2, name);

			pst.executeUpdate();




		} catch (ClassNotFoundException e) {

			System.out.println("くらすのっとえくせぷしょん");
		} catch (SQLException e) {
			System.out.println("ＳＱＬえくせぷしょん");
		} finally {

		}

	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Daoの抽象クラス オーバーライドして本処理を実行
 *
 * メソッド使用時の値、初期値はサブクラスのコンストラクタにて記述
 *
 *
 * @author ryu
 *
 */
public abstract class AbstractDao {

	/**
	 * 前処理 共通処理を記述
	 *
	 */

	public void doExecute() {

		Connection con = null;

		con = this.getCon(con);

		try {
			//本処理の実行
			execute(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 本処理のメソッド オーバーライドして使用
	 *
	 * @param con
	 * @throws SQLException
	 */
	abstract Object execute(Connection con) throws SQLException;

	public Connection getCon(Connection con) {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager
					.getConnection("jdbc:postgresql://localhost/sample",
							"postgres", "sqlpass");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
}

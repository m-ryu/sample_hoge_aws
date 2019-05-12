package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Bean;

/**
 * 抽象クラスを継承したサブクラス
 *
 * Daoの本処理を担当
 * Selectの例を記載
 *
 * @author ryu
 *
 */

public class SelectDao extends AbstractDao {

	// コンストラクタ
	public SelectDao() {

		/**
		 * ここで初期値の設定、値の格納を担当
		 */

	}

	/**
	 * 本処理
	 *
	 * @throws SQLException
	 */

	@Override
	Object execute(Connection con) throws SQLException {

		// 変数宣言
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Bean> result = new ArrayList<Bean>();

		pst = con.prepareStatement("SELECT * FROM mb2");

		//pst.setString(parameterIndex, x);t
		//pst.setInt(parameterIndex, x);

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
		return result;
	}

}
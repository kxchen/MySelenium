package cn.chenkaix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DbConnection {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement st = null;
	public ResultSet resultset = null;
	private static final Logger log = Logger.getLogger(DbConnection.class);
	static {
		try {
			log.debug("===>>>加载数据库驱动。。。");
			Class.forName(Constants.JDBC_DRIVERCLASSNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error(e.toString());
		}
	}

	public Connection getDataBaseConnection() {
		try {
			if (this.conn != null) {
				log.debug("===>>>数据库连接已存在");
				return this.conn;
			}
			log.debug("===>>>建立数据库连接");
			this.conn = DriverManager.getConnection(Constants.JDBC_URL, Constants.JDBC_USERNAME,
					Constants.JDBC_PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
			log.debug(e.toString());
		}
		return this.conn;
	}

	public void close() {
		log.debug("===>>>关闭数据库连接");
		if (this.resultset != null) {
			try {
				this.resultset.close();
				this.resultset = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (this.st != null) {
			try {
				this.st.close();
				this.st = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (this.pstmt != null) {
			try {
				this.pstmt.close();
				this.pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (this.conn != null) {
			try {
				this.conn.close();
				this.conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet resultset) {
		if (this.resultset == null) {
			this.resultset = resultset;
		}
		close();
	}
}

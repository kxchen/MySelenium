package cn.chenkaix.commons.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import cn.chenkaix.util.DbConnection;

public class SqlHelper {
	private static DbConnection dbconn = new DbConnection();
	Connection conn = dbconn.getDataBaseConnection();
	private static final Logger log = Logger.getLogger(SqlHelper.class);

	SqlHelper() {
		if (this.conn == null) {
			this.conn = new DbConnection().getDataBaseConnection();
		}
	}

	/**
	 * 方法描述 关闭数据库连接
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 下午2:34:28
	 * 
	 */
	public static void close() {
		dbconn.close();
	}

	/**
	 * 方法描述 查询第一行指定列的值，一般用于数据库sql精确查询
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 下午2:40:59
	 * 
	 * @param querysql
	 * @param colname
	 * @return
	 */
	public static String query(String querysql, String colname) {
		String str = null;
		try {
			dbconn.st = new SqlHelper().conn.createStatement();
			dbconn.resultset = dbconn.st.executeQuery(querysql);
			str = getValue(dbconn.resultset, colname);
			log.debug("DBquery==sql:" + querysql + "===获取内容：" + str);
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug(e.toString());
		} finally {
			close();
		}
		return str;
	}

	/**
	 * 方法描述 查询获取指定个字段
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 下午4:26:52
	 * 
	 * @param querysql
	 * @param colNum
	 * @return
	 */
	public static String[] query(String querysql, int colNum) {
		ArrayList<String> list = new ArrayList<>();
		try {
			dbconn.st = new SqlHelper().conn.createStatement();
			dbconn.resultset = dbconn.st.executeQuery(querysql);
			if ((dbconn.resultset != null) && (dbconn.resultset.next())) {
				for (int i = 0; i < colNum; i++) {
					list.add(dbconn.resultset.getString(i + 1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		if (dbconn.resultset == null) {
			return null;
		}
		String[] result = (String[]) list.toArray(new String[list.size()]);

		return result;
	}

	/**
	 * 方法描述 执行单条sql
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 下午2:42:38
	 * 
	 * @param sql
	 */
	public static void execute(String sql) {
		try {
			dbconn.st = new SqlHelper().conn.createStatement();
			boolean flag = dbconn.st.execute(sql);
			log.debug("DBexecute执行结果：" + flag);
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug(e.toString());
		} finally {
			close();
		}
	}

	/**
	 * 方法描述 批量执行sql
	 * 
	 * @author HEC263
	 * @time 2018年3月8日 下午3:14:06
	 * 
	 * @param sqls
	 */
	public static void execute(String[] sqls) {
		try {
			dbconn.st = new SqlHelper().conn.createStatement();
			for (String s : sqls) {
				dbconn.st.addBatch(s);
				log.debug(s);
			}
			dbconn.st.executeBatch();
		} catch (SQLException e) {
			log.debug(e.toString());
			e.printStackTrace();
		} finally {
			close();
		}
	}

	private static String getValue(ResultSet rs, String colName) {
		if (rs == null) {
			return null;
		}
		try {
			if (rs.next()) {
				return rs.getString(colName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.debug(e.toString());
		}
		return null;
	}
}

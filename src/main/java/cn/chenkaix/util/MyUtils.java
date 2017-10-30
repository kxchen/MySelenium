package cn.chenkaix.util;

public class MyUtils {

	/**
	 * @Title: getLineInfo
	 * @Description: 获得代码所在类名和行号。
	 * @return ： String
	 * @throws:
	 */
	public static String getLineInfo() {
		StackTraceElement[] ste = new Throwable().getStackTrace();
		StringBuffer sb = new StringBuffer();
		for (int i = 3; i < ste.length && i < 5; i++) {
			sb.append("===>" + ste[i].getFileName() + ":Line" + ste[i].getClassName());
		}
		return sb.toString();
	}

}

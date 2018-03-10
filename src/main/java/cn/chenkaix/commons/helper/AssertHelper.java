package cn.chenkaix.commons.helper;

import cn.chenkaix.assertion.Assert;
import cn.chenkaix.assertion.Result;
import cn.chenkaix.assertion.ResultAccumulator;
import cn.chenkaix.assertion.Validate;
import cn.chenkaix.util.Constants;
import cn.chenkaix.util.MyUtils;

/**
 * @ClassName: AssertHelper
 * @Description: 断言类。直接继承testNG的断言类。
 * @author: 15255391553@163.com
 * @date: 2017年10月30日
 * @bolg: https://kxchen.github.io
 * 
 */
public class AssertHelper extends Assert {

	/**
	 * @Title: assertString
	 * @Description: 匹配断言
	 * @param expeced
	 *            断言期望值
	 * @param actual断言实际值
	 * 			@return： void
	 * @throws:
	 */

	public static void assertString(String expeced, String actual) {
		if (Constants.VALIDATE.equals("true"))
			Validate.assertEquals(MyUtils.getLineInfo(), expeced, actual);
		else
			Assert.assertEquals(MyUtils.getLineInfo(), expeced, actual);
	}

	public static void assertString(String locator, String expeced, String actual) {
		if (Constants.VALIDATE.equals("true"))
			Validate.assertEquals("locator:" + locator + MyUtils.getLineInfo(), expeced, actual);
		else
			Assert.assertEquals("locator:" + locator + MyUtils.getLineInfo(), expeced, actual);
	}

	public static boolean isEmptyString(String s) {
		return s == null || s.toUpperCase().equals("NULL") || s.trim().equals("");
	}

	public static void sqlArrayEqual(String[] subTest, String[] subArray) {
		if (Constants.VALIDATE.equals("true"))
			Validate.assertArrayEquals(subTest, subArray);

		else
			Assert.assertArrayEquals(subTest, subArray);
	}

	public static String getAssertLog() {
		StringBuffer sb = new StringBuffer();
		for (Result rs : ResultAccumulator.INSTANCE.getResults()) {
			sb.append(rs.isFlag() + "===>" + rs.getMessage() + MyUtils.getLineInfo());
		}
		return sb.toString();
	}
}

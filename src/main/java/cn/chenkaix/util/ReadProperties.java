package cn.chenkaix.util;

import java.util.Enumeration;
import java.util.PropertyResourceBundle;

public class  ReadProperties {
	
	private final static String BROWSER = "browser"; // 属性文件名称
	static String FIREFOX_DRIVER_PATH;
	static String FIREROX_APP_PATH;
	static String CHROME_DRIVER_PATH;
	static String CHROME_APP_PATH;
	static String IE_DRIVER_PATH;
	static String IE_APP_PATH;
	static String OTHER_DRIVER_PATH;
	static String OTHER_APP_PATH;
	static {
		readBrowserConfig();
	}

	/**
	 * @Title: readBrowserConfig
	 * @Description: 读取浏览器配置文件 @return： void
	 * @throws:
	 */
	@SuppressWarnings("all")
	private static void readBrowserConfig() {
		// PropertyResourceBundle使用属性文件中的静态字符串集合来管理语言环境资源。
		PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle.getBundle(BROWSER);
		// 枚举Enumeration
		Enumeration enu = prb.getKeys();
		while (enu.hasMoreElements()) {
			String propertyName = enu.nextElement().toString();
			// 读取配置文件中的静态字符串并且赋值给类成员变量
			if (propertyName.equals("firefox.driver.path"))
				FIREFOX_DRIVER_PATH = prb.getString("firefox.driver.path");
			if (propertyName.equals("firefox.app.path"))
				FIREROX_APP_PATH = prb.getString("firefox.app.path");
			if (propertyName.equals("chrome.driver.path"))
				CHROME_DRIVER_PATH = prb.getString("chrome.driver.path");
			if (propertyName.equals("chrome.app.path"))
				CHROME_APP_PATH = prb.getString("chrome.app.path");
			if (propertyName.equals("ie.driver.path"))
				IE_DRIVER_PATH = prb.getString("ie.driver.path");
			if (propertyName.equals("ie.app.path"))
				IE_APP_PATH = prb.getString("ie.app.path");
		}

	}

}

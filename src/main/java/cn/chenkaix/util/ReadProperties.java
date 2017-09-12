package cn.chenkaix.util;

import java.util.Enumeration;
import java.util.PropertyResourceBundle;

import org.apache.log4j.Logger;

public class ReadProperties {
	private static final Logger log = Logger.getLogger(ReadProperties.class);
	private final static String BROWSER = "browser"; // 属性文件名称
	private static String FIREFOX_DRIVER_PATH;
	private static String FIREROX_APP_PATH;
	private static String CHROME_DRIVER_PATH;
	private static String CHROME_APP_PATH;
	private static String IE_DRIVER_PATH;
	private static String IE_APP_PATH;

	public static String getFIREFOX_DRIVER_PATH() {
		return FIREFOX_DRIVER_PATH;
	}

	public static String getFIREROX_APP_PATH() {
		return FIREROX_APP_PATH;
	}

	public static String getCHROME_DRIVER_PATH() {
		return CHROME_DRIVER_PATH;
	}

	public static String getCHROME_APP_PATH() {
		return CHROME_APP_PATH;
	}

	public static String getIE_DRIVER_PATH() {
		return IE_DRIVER_PATH;
	}

	public static String getIE_APP_PATH() {
		return IE_APP_PATH;
	}

	static {
		log.info("开始初始化配置文件");
		readBrowserConfig();

		log.info("初始化配置文件结束");
	}

	/**
	 * @Title: readBrowserConfig
	 * @Description: 读取浏览器配置文件
	 */
	@SuppressWarnings("all")
	private static void readBrowserConfig() {
		log.info("开始读取浏览器信息");
		// PropertyResourceBundle使用属性文件中的静态字符串集合来管理语言环境资源。
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		log.info("读取浏览器信息结束");
	}

}
